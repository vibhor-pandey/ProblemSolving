package DynamicPrograming;

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
