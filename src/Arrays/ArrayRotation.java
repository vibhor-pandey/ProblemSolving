package Arrays;


import Mathematical.GCD;
import Utility.Utility;

import java.util.*;
import java.lang.*;

public class ArrayRotation {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();

        for(int testCase = 0; testCase < testCases; testCase++) {
            int arrSize = in.nextInt();
            int rotationSize = in.nextInt();
            int[] array = Utility.readArray(in, arrSize);
            int[] rotatedArr = rotateArrayByJugguling(array, arrSize, rotationSize);
            Utility.printArray(rotatedArr, arrSize);
        }
    }

    public static int[] rotateArrayByJugguling(int[] array, int size, int rSize) {
        //"rSize % size"
        //When Rotation size > Array size
        int r = rSize % size;
        int gcd = GCD.getGCD(size, r);
        for(int i = 0; i < gcd; i++) {
            int temp = array[i];
            int j = i;
            while(true) {
                int nextIndex = j + r;
                if(nextIndex >= size) {
                    nextIndex = nextIndex - size;
                }
                if(nextIndex == i) break;
                array[j] = array[nextIndex];
                j = nextIndex;
            }
            array[j] = temp;
        }
        return array;
    }
}
