package Arrays;

/***
 * You are given a large integer represented as an integer array digits,
 * where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order.
 * The large integer does not contain any leading 0's.
 *
 * Increment the large integer by one and return the resulting array of digits.
 *
 *
 *
 * Example 1:
 *
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Incrementing by one gives 123 + 1 = 124.
 * Thus, the result should be [1,2,4].
 * Example 2:
 *
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Incrementing by one gives 4321 + 1 = 4322.
 * Thus, the result should be [4,3,2,2].
 * Example 3:
 *
 * Input: digits = [9]
 * Output: [1,0]
 * Explanation: The array represents the integer 9.
 * Incrementing by one gives 9 + 1 = 10.
 * Thus, the result should be [1,0].
 *
 *
 * Constraints:
 *
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * digits does not contain any leading 0's.
 */


import java.util.*;

public class PlusOne {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param digits
     * @return
     */
    public int[] plusOneNaive(int[] digits) {
        int len = digits.length;
        List<Integer> plusOne = new ArrayList<>(len + 1);

        int value = digits[len - 1] + 1;
        int carry = value / 10;
        for(int i = len - 1; i >= 0; i--) {
            plusOne.add(value % 10);
            if ( i != 0) {
                value = digits[i - 1] + carry;
            } else if (carry != 0){
                plusOne.add(carry);
            }
            carry = value / 10;
        }
        Collections.reverse(plusOne);
        return plusOne.stream().mapToInt(i -> i).toArray();
    }


    /**
     * Time Complexity: O(n)
     * Time Complexity: O(n)
     * @param digits
     * @return
     */
    public int[] plusOneOptimized(int[] digits) {
        int len = digits.length;
        for(int i = len - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            }
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }
}
