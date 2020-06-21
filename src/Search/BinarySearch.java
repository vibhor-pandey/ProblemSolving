package Search;

import Utility.Utility;

import java.util.Scanner;

public class BinarySearch {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();

        for(int testCase = 0; testCase < testCases; testCase++) {
            int size = in.nextInt();
            int[] array = Utility.readArray(in, size);
            int key = in.nextInt();
            int index = binarySearch(array, 0, size - 1, key);
            System.out.println(index);
        }
    }

    public static int binarySearch(int[] arr, int start, int end, int key) {
        int mid = (start + end) / 2;
        if(start > end) return -1;
        else if(key == arr[mid]) return mid;
        else if(key > arr[mid]) return binarySearch(arr, mid + 1, end, key);
        else return binarySearch(arr, start, mid, key);
    }
}
