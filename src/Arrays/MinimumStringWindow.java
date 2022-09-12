package Arrays;

/**
 * Given two strings s and t of lengths m and n respectively,
 * return the minimum window substring of s such that every character in t (including duplicates) is included in the window.
 * If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 *
 * A substring is a contiguous sequence of characters within the string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * Example 2:
 *
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * Example 3:
 *
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 *
 *
 * Constraints:
 *
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s and t consist of uppercase and lowercase English letters.
 */


import java.util.*;
import java.util.stream.Collectors;

public class MinimumStringWindow {

    public String minWindow(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        String minWindowString = "";
        //If length(S) < length(T): No answer
        if(sLength < tLength) return minWindowString;
        //If length(S) == length(T)
        if(sLength == tLength) {
            return s.equals(t) ? s : "";
        }

        List<Character> tC = t.chars().mapToObj(e -> (char)e).collect(Collectors.toList());

        int leftPointer = 0;
        int rightPointer = 0;
        int prevWindowStart = 0;
        int nextWindowStart = 0;

        while(leftPointer <= (sLength - tLength)) {
            if(!tC.contains(s.charAt(rightPointer))) {
                leftPointer++;
                rightPointer++;
                continue;
            }
            while(tC.size() > 0 && rightPointer < sLength) {
                if(tC.contains(s.charAt(rightPointer))) {
                    tC.remove(new Character(s.charAt(rightPointer)));
                    if(tC.size() == (tLength - 2)) {
                        prevWindowStart = nextWindowStart;
                        nextWindowStart = rightPointer;
                    }
                }
                rightPointer++;
            }
            System.out.println(leftPointer + ", " + rightPointer);
            System.out.println(tC);
            if(minWindowString.isEmpty() || (tC.size() == 0 &&
                    minWindowString.length() > (rightPointer - leftPointer))) {
                minWindowString = s.substring(leftPointer, rightPointer);
            }
            System.out.println(minWindowString);
            if(nextWindowStart == prevWindowStart) {
                leftPointer++;
                rightPointer = leftPointer;
                break;
            }
            tC = t.chars().mapToObj(e -> (char)e).collect(Collectors.toList());
            leftPointer = nextWindowStart;
            rightPointer = nextWindowStart;
        }
        return minWindowString;
    }
}
