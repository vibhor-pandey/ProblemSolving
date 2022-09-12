package Arrays;

import SortingAndSearching.BinarySearch;
import Utility.Utility;

import java.util.*;

public class SearchInRotatedArray {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();

        for(int testCase = 0; testCase < testCases; testCase++) {
            int size = in.nextInt();
            int[] array = Utility.readArray(in, size);
            int key = in.nextInt();
            int pivot = findPivot(array, size);
            int index = 0;
            if(key > array[0]) {
                index = BinarySearch.binarySearch(array, 0, pivot - 1, key);
            } else {
                index = BinarySearch.binarySearch(array, pivot, size - 1, key);
            }
            System.out.println(index);
        }
    }

    public static int findPivot(int[] arr, int size) {
        int pivot = 0;
        for(int i = 0; i < size - 1; i++) {
            if(arr[i] > arr[i + 1]) {
                pivot = i + 1;
                break;
            }
        }
        return pivot;
    }
}
