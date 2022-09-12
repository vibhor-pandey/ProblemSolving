package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_Iterative {

    private List<List<Integer>> answer;

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        answer = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++) {
            if((i == 0 || nums[i] != nums[i - 1]) && nums[i] <= 0) {
                twoSum(i, nums);
            }
        }
        return answer;
    }

    public void twoSum(int firstIndex, int[] nums) {
        int diff = 0 - nums[firstIndex];
        int length = nums.length;
        for(int i = firstIndex + 1; i < nums.length - 1; i++) {
            if(i > (firstIndex + 1) && nums[i] == nums[i - 1]) {
                continue;
            }
            int secondIndex = binarySearch(i + 1, diff - nums[i], nums);
            if(secondIndex != -1 && nums[firstIndex] + nums[i] + nums[secondIndex] == 0) {
                List<Integer> triplets = new ArrayList<>();
                triplets.add(nums[firstIndex]);
                triplets.add(nums[i]);
                triplets.add(nums[secondIndex]);
                answer.add(new ArrayList<>(triplets));
            }
        }
    }

    private int binarySearch(int start, int target, int[] nums) {
        int end = nums.length - 1;
        int mid = (end + start) / 2;
        while(start <= end) {
            if(target < nums[mid]) {
                end = mid - 1;
            } else if(target > nums[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
            mid = ((end + start) / 2);
        }
        return -1;
    }
}
