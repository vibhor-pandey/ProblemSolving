package DynamicPrograming.Array;

public class JumpGame {
    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     * MEMO[i] = -1/0/1 (UNKNOWN/BAD/GOOD)
     *
     * 1) Init MEMO with -1 (UNKNOWN)
     * 2)MEMO[len - 1] = 1 (GOOD)
     * 3) Iterate from Right -> Left
     *     4) MaxJump = Min(Jump, len - 1)
     *     5) Iterate throught right if jTH -> MaxJump
     *         6) Check IF any GOOD(1) on right ? MEMO[i] = 1 (GOOD) : continue
     *  7) return MEMO[i] == 0
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int memo[] = new int[len];
        for(int i = 0; i < len; i++) {
            memo[i] = -1;
        }
        memo[len - 1] = 1;

        for(int i = len - 2; i >= 0; i--) {
            int maxJump = Math.min(i + nums[i], len - 1);
            //Check Right of the iTH index with GOOD Jump
            for(int j = i + 1; j <= maxJump; j++) {
                if(memo[j] == 1) {
                    memo[i] = 1;
                    break;
                }
            }
        }
        return memo[0] == 1 ? true : false;
    }


    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * 1) Start from Right -> Left
     * 2) if i + nums[i] >= LAST_GOOD_POSITION
     * 3) UPDATE LAST_GOOD_POSITION = i
     * 4) return LAST_GOOD_POSITION == 0
     * @param nums
     * @return
     */
    public boolean canJumpOptimized(int[] nums) {
        int len = nums.length;
        int lastGoodPosition = len - 1;
        for(int i = len - 1; i >= 0; i--) {
            if(i + nums[i] >= lastGoodPosition) {
                lastGoodPosition = i;
            }
        }
        return lastGoodPosition == 0;
    }
}
