package StringHandling;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */

public class LengthOfLongestSubstring {

    /**
     * Runtime: 891 ms
     * Memory Usage: 191 MB
     *
     */
    public int lengthOfLongestSubstring(String s) {
        String temp = "";
        int size = 0;
        for(int i = 0; i < s.length(); ) {
            if(!temp.contains(s.charAt(i) + "")) {
                temp += s.charAt(i);
                i++;
            } else {
                size = Math.max(size, temp.length());
                temp = "";
                s = s.substring(s.indexOf(s.charAt(i) + "") + 1);
                i = 0;
            }
        }
        size = Math.max(temp.length(), size);
        return size;
    }

    /**
     * Runtime: 14 ms
     * Memory Usage: 45.7 MB
     *
     */
    public int lengthOfLongestSubstringOptimized(String s) {
        Set<Character> temp = new HashSet<>();
        int leftPointer = 0;
        int rightPointer = 0;
        int size = 0;
        while(rightPointer < s.length()) {
            if(!temp.contains(s.charAt(rightPointer))) {
                temp.add(s.charAt(rightPointer));
                rightPointer++;
            } else {
                size = Math.max(size, temp.size());
                temp.remove(s.charAt(leftPointer));
                leftPointer++;
            }
        }
        size = Math.max(temp.size(), size);
        return size;
    }
}
