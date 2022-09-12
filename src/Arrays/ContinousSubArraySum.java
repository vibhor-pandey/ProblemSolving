package Arrays;

/**
You are given an array A of non-negative numbers and a target sum S.
Write an efficient function that finds one continuous sub-sequence of elements which sum up to precisely S.
The return value should be a pair of array indices or null.

Examples:
A = [ 1, 2, 2, 3 ], S = . Result = [ 1, 3 ]
A = [ 1, 2, 2, 1 ], S = 7. Result = [ 1, 3 ]
 */

/**
Two Pointers: left pointer & right pointer
*/

public class ContinousSubArraySum {
    public static int[] getSumIndices(int[] a, int sum) {
        if(a.length == 0) return null;
        if(a.length == 1 && a[0] == sum) {
            return new int[] {0};
        }

        int left = 0;
        int right = 0;
        int pairSum = 0;
        while(left <= right) {
            pairSum += a[right];
            if(pairSum < sum) {
                right++;
            } else if(pairSum > sum){
                while(pairSum > sum && left <= right) {
                    pairSum -= a[left];
                    left++;
                }
            }
            if(sum == pairSum) break;
        }
        if(left > right) {
            right = left;
        }
        return new int[] {left, right};
    }
}
