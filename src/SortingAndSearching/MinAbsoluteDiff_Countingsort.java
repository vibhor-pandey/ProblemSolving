package SortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinAbsoluteDiff_Countingsort {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int minElement = arr[0];
        int maxElement = arr[0];

        //1) Find min & max from Array
        for(int num : arr) {
            minElement = Math.min(minElement, num);
            maxElement = Math.max(maxElement, num);
        }

        //2) Create index shift for negative numbers
        int shift = -minElement;
        int line[] = new int[maxElement - minElement + 1];
        //3) Initialize Line[num] Array with 1 for num present in Array
        for(int num : arr) {
            line[num + shift] = 1;
        }

        int minDifference = maxElement - minElement;
        int prev = 0;
        List<List<Integer>> ans = new ArrayList<>();

        for(int curr = 1; curr <= maxElement + shift; curr++) {
            if(line[curr] == 0) continue;

            if(curr - prev == minDifference) {
                ans.add(Arrays.asList(prev - shift, curr - shift));
            } else if(curr - prev < minDifference) {
                ans = new ArrayList<>();
                minDifference = curr - prev;
                ans.add(Arrays.asList(prev - shift, curr - shift));
            }
            prev = curr;
        }
        return ans;
    }
}
