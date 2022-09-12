package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * For the main function:
 *
 * Sort the input array nums.
 * Iterate through the array:
     * If the current value is greater than zero, break from the loop. Remaining values cannot sum to zero.
     * If the current value is the same as the one before, skip it.
     * Otherwise, call twoSumII for the current position i.
     * For twoSumII function:
 *
 * Set the low pointer lo to i + 1, and high pointer hi to the last index.
 * While low pointer is smaller than high:
     * If sum of nums[i] + nums[lo] + nums[hi] is less than zero, increment lo.
     * If sum is greater than zero, decrement hi.
     * Otherwise, we found a triplet:
     * Add it to the result res.
     * Decrement hi and increment lo.
     * Increment lo while the next value is the same as before to avoid duplicates in the result.
     * Return the result res.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length && nums[i] <=0; i++) {
            if(i == 0 || nums[i - 1] != nums[i]) {
                twoSumII(nums, i, result);
            }
        }
        return result;
    }

    /**
     * Time Complexity: O(n^2)
     * Space Complexity O(n)
     * @param nums
     * @param i
     * @param res
     */
    void twoSumII(int[] nums, int i, List<List<Integer>> res) {
        int lo = i + 1;
        int hi = nums.length - 1;
        while(lo < hi) {
            int sum = nums[i] + nums[lo] + nums[hi];
            if(sum > 0) {
                hi--;
            } else if (sum < 0) {
                lo++;
            } else {
                res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                while(lo < hi && nums[lo] == nums[lo -1]) {
                    lo++;
                }
            }
        }
    }
}
