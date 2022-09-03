package Stacks;

/**
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
 * Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc.
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k.
 * For example, there will not be input like 3a or 2[4].
 *
 * The test cases are generated so that the length of the output will never exceed 105.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * Example 2:
 *
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * Example 3:
 *
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 */


import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DecodeString {
    public static List<Character> digits = Arrays.asList(new Character[] {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'});

    public String decodeString(String encoded) {
        Stack<Character> s = new Stack<>();
        String str = "";
        char[] ch = encoded.toCharArray();
        for(char c : ch) {
            if (c == ']'){
                decode(s);
                continue;
            }
            s.push(c);
        }
        return getDecodedString(s);
    }

    private String getDecodedString(Stack<Character> s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s) {
            sb.append(c);
        }
        return sb.toString();
    }

    private void decode(Stack<Character> s) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        StringBuilder num = new StringBuilder();
        while(s.peek() != '[') {
            sb.insert(0, s.pop());
        }
        s.pop();
        while(!s.isEmpty() && digits.contains(s.peek())) {
            num.insert(0, s.pop());
        }
        int digit = Integer.parseInt(num.toString());
        for(int i = 0; i < digit; i++) {
            sb1.append(sb.toString());
        }

        for(char c : sb1.toString().toCharArray()) {
            s.push(c);
        }
    }
}

