package StringHandling;


/**
 * 1) For each char in Strinh
 *      2) Set low (i - 1) & high (i + 1)
 *      3) Increment high till CharAt(i) ==  CharAt(high) {increment till Current char is equal}
 *      4) Decrement low till CharAt(i) ==  CharAt(low) {decrement till Current char is equal}
 *      5) Continue Step-6 until CharAt(low) == CharAt(high)
 *          6) low-- & high++;
 *      7) Check MaxLength is Max, if yes, update indices
 * 8) Return substring
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int len = s.length();
        int maxLength = -1;
        int right = 0;
        int left = 0;
        for(int i = 0; i < s.length() - 1; i++) {
            int low = i - 1;
            int high = i + 1;
            while(high < len && s.charAt(i) == s.charAt(high))
                high++;
            while(low >= 0 && s.charAt(i) == s.charAt(low))
                low--;

            while(low >= 0 && high < len && s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
            }
            if(maxLength < (high - low - 2)) {
                maxLength =  high - low - 2;
                right = high - 1;
                left = low + 1;
            }
        }
        return s.substring(left, right + 1);
    }
}
