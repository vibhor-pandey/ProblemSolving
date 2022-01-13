/**
 * Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
 *
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
 *
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 *
 *
 *
 * Example 1:
 *
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * Example 2:
 *
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * Example 3:
 *
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 */

package DynamicPrograming;

public class LongestCommonSubsequenece {
    public int[][] memo;
    public char[] left;
    public char[] right;

    public int longestCommonSubsequence(String text1, String text2) {
        left = text1.toCharArray();
        right = text2.toCharArray();
        memo = new int[left.length + 1][right.length + 1];
        // dp(left.length, right.length);

        for(int i = 1; i <= left.length; i++) {
            for(int j = 1; j <= right.length; j++) {
                if(left[i - 1] == right[j - 1]) {
                    memo[i][j] = memo[i-1][j-1] + 1;
                } else {
                    memo[i][j] = Math.max(memo[i][j - 1], memo[i - 1][j]);
                }
            }
        }
        return memo[left.length][right.length];
    }

    public int dp(int i, int j) {
        if(i == 0 || j == 0) return 0;
        if(left[i - 1] == right[j - 1]) {
            memo[i][j] = Math.max(dp(i-1, j-1), dp(i, j - 1)) + 1;
        } else {
            memo[i][j] = Math.max(dp(i-1, j), dp(i, j - 1));
        }
        return memo[i][j];
    }
}
