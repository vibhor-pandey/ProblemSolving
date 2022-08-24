package Arrays;

import java.util.*;
import java.util.stream.Collectors;

public class MinimusStringWindow {

    public String minWindow(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        String minWindowString = "";
        if(sLength < tLength) return minWindowString;
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
