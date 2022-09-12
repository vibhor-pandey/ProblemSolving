package Arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
//Intuition:
//There is no difference between the purpose of k1 and k2, so we add them together and store it as a variable k
//Every time we want to find the maximum difference and reduce the difference, so we need to use a PriorityQueue to track the max diff
//But if every time we reduce the max diff by one, that will be time consuming. So here is the new strategy:
//The first time we poll a max diff, we store it to a variable prev, and cnt equals 1
//The next time we get another max diff, we try to reduce prev to the current max diff, and cnt++
//Thus (prev - current max diff) * cnt is the total times we have to reduce to maintain this structure,
//until (prev - current max diff) * cnt > k
//If (prev - current max diff) * cnt > k, it means we can not reduce all the previous number to the current max diff

//Example:
//max diff: [10, 8, 5, 5, 1]  k = 18
//max diff: [8, 8, 5, 5, 1]  k = 16  prev = 8  cnt = 2
//max diff: [5, 5, 5, 5, 1]  k = 10  prev = 5  cnt = 3
//max diff: [5, 5, 5, 5, 1]  k = 10  prev = 5  cnt = 4
//max diff: then (prev - current max diff) * cnt > k
//We enter into else condition, now we have  max diff = [5, 5, 5, 5, 1]  k = 10  prev = 5  cnt = 4
//we want to reduce the previous five's all to 1, but the remaining k is not enough for us to do that,
//so we can only all the previous five's to a value that is larger than one.
//Thus we have int a = k / cnt = 2; int b = k % cnt = 2; int c = prev - a = 3;
//a is the maximum value we can reduce, b is the remaining value that we can reduce after reducing a,
//c is the value after we reduce a.
//Thus, after reducing a, we have: max diff: [3, 3, 3, 3, 1]
//And we still have b = 2 remaining, so we reduce the first two values by one,
//then we have max diff: [2, 2, 3, 3, 1], this is what we want

class Solution {

    /*
    1) DIFF[] = Find the difference of each | num1[i] - num2[i] |
    2) MAP<DIFF[i], count> = Get diff, count map from DIFF[]
    3) Store each <Diff, Count> in Max PQ()(a, b) -> b[0] - a[0])
    4) PREV = PQ.poll()
    4) While (PQ.isEmpty || Operations > 0)
    5)      CURR = PQ.poll()
    6)      IF (PREV.key - CURR.key) * PREV.count <= Operations
    7)          Operations -= PREV.count
    8)          CURR[1] += PREV.count
    9)      ELSE
    10)         ED = Operations / PREV.Count
    11)         REM = Operations -  ED * PREV.Count
    12)         LK = PREV.key - ED
    13)         Operations = 0
    14)         PQ.add(LK, PREV.count - REM)
    15)         PQ.add(LK - 1, REM)
    16) Return SUM(PQ.Keys())
    */

    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        Map<Integer, Integer> diffFreq = new HashMap<>();
        for(int i = 0; i < nums1.length; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            diffFreq.put(diff, diffFreq.getOrDefault(diff, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for(int key : diffFreq.keySet()) {
            pq.offer(new int[] {key, diffFreq.get(key)});
        }

        int k = k1 + k2;
        while(!pq.isEmpty() && k > 0) {
            int[] curr = pq.poll();
            int count = curr[1];
            int currDiff = curr[0];

            int nextDiff = 0;
            if(pq.isEmpty()) {
                nextDiff = pq.peek()[1];
            } else {
                pq.offer(new int[] {0, 0});
            }

            if((currDiff - nextDiff) * count <= k) {
                k -= count;
                curr[1] += count;
            } else {
                int ed = k / count;
                int rem = k - ed * count;
                int lk = currDiff - ed;
                pq.offer(new int[] {lk, count - rem});
                pq.offer(new int[] {lk - 1, rem});
                k = 0;
            }
        }

        long ans = 0;
        for(int[] pair : pq) {
            ans += (pair[0] * pair[0] * pair[1]);
        }
        return ans;
    }
}

public class MinSumOfSquaredDiff {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.add(0);
        for (int i = 0; i < nums1.length; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            if (diff > 0)
                pq.add(diff);
        }
        int k = k1 + k2;
        int prev = 0, cnt = 0;
        while (k > 0 && !pq.isEmpty()) {
            int cur = pq.poll();
            long x = (prev - cur) * cnt;
            if (x <= k) {
                prev = cur;
                cnt++;
                k -= x;
            } else {
                int a = k / cnt;
                int b = k % cnt;
                int c = prev - a;
                for (int i = 0; i < cnt - b; i++)
                    pq.add(c);
                for (int i = 0; i < b; i++)
                    pq.add(c - 1);
                pq.add(cur);
                k = 0;
            }
        }
        long ans = 0;
        for (long diff : pq)
            ans += (long)diff * diff;
        return ans;
    }
}
