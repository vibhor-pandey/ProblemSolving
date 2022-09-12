package Arrays;
/**
 * 1) first_num = second_num = some very big number
 * 2) for n in nums:
 *     3) if n is smallest number:
 *         4) first_num = n
 *     5) else if n is second smallest number:
 *         6) second_num = n
 *     7) else n is bigger than both first_num and second_num:
 *         # We have found our triplet, return True
 * 8) return false;
 */
public class IncreasingTripletsSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int firstNum = Integer.MAX_VALUE;
        int secondNum = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] <= firstNum) {
                firstNum = nums[i];
            } else if(nums[i] <= secondNum) {
                secondNum = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }
}
