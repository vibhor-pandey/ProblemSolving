package Utility;

import java.util.Scanner;

public class Utility {

    public static void printArray(int[] array, int size) {
        for(int itr = 0; itr < size; itr++) {
            System.out.print(array[itr] + " ");
        }
        System.out.println();
    }

    public static int[] readArray(Scanner in, int arrSize) {
        int[] arr = new int[arrSize];
        for(int itr = 0; itr < arrSize; itr++) {
            arr[itr] = in.nextInt();
        }
        return arr;
    }
}
