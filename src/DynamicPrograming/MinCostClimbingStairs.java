package DynamicPrograming;

import java.util.*;

public class MinCostClimbingStairs {

    private Map<Integer, Integer> memo = new HashMap<>();
    private int cost[];

    public int minCostClimbingStairs(int[] cost) {
        this.cost = cost;
        int result = this.climbStairsTopDown(cost.length);
        return result;
    }

    private int climbStairsTopDown(int i) {
        if (i == 0 || i == 1) return 0;
        if(!memo.containsKey(i)) {
            memo.put(i, Math.min(cost[i - 1] + climbStairsTopDown(i - 1), cost[i - 2] + climbStairsTopDown(i - 2)));
        }
        return memo.get(i);
    }

}
