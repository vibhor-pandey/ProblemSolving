package StringHandling;

/**
 * Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abab"
 * Output: true
 * Explanation: It is the substring "ab" twice.
 * Example 2:
 *
 * Input: s = "aba"
 * Output: false
 * Example 3:
 *
 * Input: s = "abcabcabcabc"
 * Output: true
 * Explanation: It is the substring "abc" four times or the substring "abcabc" twice.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of lowercase English letters.
 */

public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        if(s.length() == 1 || s.length() % 2 != 0) return false;
        char c = s.charAt(0);
        char[] chars = s.toCharArray();
        String substring = c + "";
        for(int i = 1; i < chars.length; i++) {
            if(chars[i] == c) {
                break;
            }
            substring += chars[i];
        }
        System.out.println(substring);
        if(s.length() % substring.length() != 0) return false;
        StringBuilder sb = new StringBuilder(s);
        while(sb.length() > 0) {
            System.out.print(s.toString() + ", ");
            if(sb.indexOf(substring) == -1) break;
            int end = sb.indexOf(substring) + substring.length();
            sb = new StringBuilder(sb.substring(end));

        }
        if(sb.length() == 0) return true;
        return false;
    }
}
