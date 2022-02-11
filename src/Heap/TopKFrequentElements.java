package Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numCount = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> numCount.get(n1) - numCount.get(n2));
        for(int num : nums) {
            if(numCount.containsKey(num)) {
                numCount.put(num, numCount.get(num) + 1);
            } else {
                numCount.put(num, 1);
            }
        }

        for(int num : numCount.keySet()) {
            if(heap.size() == k) {
                if(numCount.get(heap.peek()) < numCount.get(num)) {
                    heap.poll();
                    heap.add(num);
                }
            } else {
                heap.add(num);
            }
        }
        int[] result = new int[k];
        for(int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }

        return result;
    }
}
