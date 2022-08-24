package DynamicPrograming;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money
 * you can rob tonight without alerting the police.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 *
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 */


import java.util.*;

public class HouseRobber {
    private Map<Integer, Integer> memo = new HashMap<>();
    private int[] nums;
    private final static Boolean IS_TOP_DOWN = true;

    public int rob(int[] nums) {
        this.nums = nums;
        return IS_TOP_DOWN? topDownDP(nums.length - 1) : bottomUpDP();
    }

    private int topDownDP(int i) {
        if (i == 0) return nums[0];
        if (i == 1) return Math.max(nums[0], nums[1]);
        if(!memo.containsKey(i)) {
            this.memo.put(i, Math.max(topDownDP(i - 1), topDownDP(i - 2) + nums[i]));
        }
        System.out.println(i + "th Step:" + memo.get(i));
        return memo.get(i);
    }

    private int bottomUpDP() {
        memo.put(0, nums[0]);
        memo.put(1, Math.max(nums[0], nums[1]));
        for(int i = 2; i < nums.length; i++) {
            if (!memo.containsKey(i)) {
                memo.put(i, Math.max(memo.get(i - 1), memo.get(i - 2) + nums[i]));
            }
        }
        return memo.get(nums.length - 1);
    }
}
