package Mathematical;

import java.util.*;
import java.lang.*;

public class GCD
{
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();

        for(int testCase = 0; testCase < testCases; testCase++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int gcd = 0;
            if(a > b) {
                gcd = getGCD(a, b);
            } else {
                gcd = getGCD(b, a);
            }
            System.out.println(gcd);
        }
    }


    // Variable 'a' Value must be Greater than
    //Variable 'b' value
    public static int getGCD(int a, int b) {
        if(a % b == 0) {
            return b;
        } else {
            return getGCD(b, a % b);
        }
    }
}