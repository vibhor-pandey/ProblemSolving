package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
