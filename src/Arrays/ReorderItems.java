package Arrays;/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
*/
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

public class ReorderItems {


    public static int[] reorderItems(int[] arr, int a, int b) {
        int len = arr.length;
        int indexOf_a = -1;
        int indexOf_b = -1;
        for(int i = 0; i < len; i++) {
            if(arr[i] == a) {
                indexOf_a = i;
            }
            if(arr[i] == b) {
                indexOf_b = i;
            }
            if (indexOf_a != -1 && indexOf_b != -1) {
                break;
            }
        }
        if (indexOf_a == -1 && indexOf_b == -1) {
            return arr;
        }

        if (indexOf_a < indexOf_b) {
            //Left Shift
            int temp = arr[indexOf_a + 1];
            for(int i = indexOf_a + 1; i < indexOf_b; i++) {
                arr[i] = arr[i + 1];
            }
            arr[indexOf_b] = temp;
        } else {
            //Right Shift
            int temp = arr[indexOf_a + 1];
            for(int i = indexOf_a + 1; i > indexOf_b; i--) {
                arr[i] = arr[i - 1];
            }
            arr[indexOf_b + 1] = temp;
        }
        return arr;
    }

    public static void main(String args[] ) throws Exception {

        //Scanner
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int[] arr = new int[len];
        for(int itr = 0; itr < len; itr++) {
            arr[itr] = in.nextInt();
        }

        int operations = in.nextInt();
        for(int itr = 0; itr < operations; itr++) {
            int a = in.nextInt();
            int b = in.nextInt();
            arr = reorderItems(arr, a, b);
        }
        printArray(arr, len);

    }

    public static void printArray(int[] array, int size) {
        for(int itr = 0; itr < size; itr++) {
            System.out.print(array[itr] + " ");
        }
        System.out.println();
    }
}
