package StringHandling;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1) Sort by Length {O(N * lgN)}
 * 2) List<Char> C: Get the first String from Sorted List<String> as list
 * 3) For Second String -> Last string in List<String>
 *     4) Remove chars from C which are not part of the prefix
 *     5) if isEmpty(C) return ""
 * 6) Return remaining characters of List<Char> C
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        Arrays.sort(strs, (a, b) -> a.length() - b.length());
        List<Character> c = strs[0].chars().mapToObj(i -> (char) i).collect(Collectors.toList());

        for(int i = 1; i < strs.length; i++) {
            String current = strs[i];
            int removeCharsFrom = -1;
            int cIndex = c.size() - 1;
            while(cIndex >= 0) {
                if(current.charAt(cIndex) != c.get(cIndex)) {
                    removeCharsFrom = cIndex;
                }
                cIndex--;
            }
            if(removeCharsFrom == 0 || c.isEmpty()) {
                return "";
            } else if(removeCharsFrom != -1){

                c.subList(removeCharsFrom, c.size()).clear();
            }
        }
        StringBuilder answer = new StringBuilder();
        for(Character cr : c) {
            answer.append(cr);
        }
        return answer.toString();
    }
}
