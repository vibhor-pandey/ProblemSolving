package StringHandling;

/**
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 *
 * Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 *
 *
 * Example 1:
 *
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * Example 2:
 *
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 *
 *
 * Constraints:
 *
 * 1 <= num1.length, num2.length <= 200
 * num1 and num2 consist of digits only.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 */


/**
 * USE BASIC ARITHMETIC SOLUTION
 */
public class MuliplyStrings {

    /**
     * Time Complexity: O(m * n) = O(n^2)
     * Space Complexity: O(n)
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        int[] result = new int[len1 + len2];

        for (int i = len2 - 1; i >= 0; i--) {
            int multiplier = num2.charAt(i) - '0';
            int carry = 0;
            for(int j = len1 - 1; j >= 0; j--) {
                int multiplicand = num1.charAt(j) - '0';
                int value = carry + (multiplier * multiplicand);
                int n = result[i + j + 1] + (value % 10);
                result[i + j + 1] = (n % 10);
                result[i + j] += (int) Math.floor(n / 10);
                carry = (int) Math.floor(value / 10);
            }
            result[i] += carry;
        }
        return discardZeros(result);
    }

    public String discardZeros(int[] result) {
        StringBuilder multiply = new StringBuilder("");
        for(int i = 0; i < result.length; i++) {
            if(multiply.length() == 0 && result[i] == 0) {
                continue;
            }
            multiply.append(result[i]);
        }
        return multiply.toString();
    }
}
