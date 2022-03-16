package Arrays;

/**
 * A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
 *
 * For example, for arr = [1,2,3], the following are considered permutations of arr: [1,2,3], [1,3,2], [3,1,2], [2,3,1].
 * The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).
 *
 * For example, the next permutation of arr = [1,2,3] is [1,3,2].
 * Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
 * While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
 * Given an array of integers nums, find the next permutation of nums.
 *
 * The replacement must be in place and use only constant extra memory.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [1,3,2]
 * Example 2:
 *
 * Input: nums = [3,2,1]
 * Output: [1,2,3]
 * Example 3:
 *
 * Input: nums = [1,1,5]
 * Output: [1,5,1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 */

import java.util.Arrays;

/**
 * 1) Find a[i] such that a[i] > a[i - 1] (Right of a[i - 1] is in DESCENDING ORDER)
 * 2) Find a[j] in {a[i]....a[n]} such that a[j] JUST GREATER THAN a[i - 1]
 * 3) SWAP(a[i-1] & a[j])
 * 4) Reverse {a[i]...a[n]} to ASCENDING ORDER to get NEXT PERMUTATION
 */
public class NextPermutation {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        boolean isNextPermutation = false;
        for (int i = len - 1; i >= 1; i--) {
            if(nums[i] > nums[i - 1]) {
                int justGreater = Integer.MAX_VALUE;
                int index = -1;
                for(int j = i; j < len; j++) {
                    int diff = nums[j] - nums[i - 1];
                    if(diff > 0 && diff <= justGreater) {
                        justGreater = diff;
                        index = j;
                    } else if(diff < 0) {
                        break;
                    }
                }
                swap(i-1, index, nums);
                reverse(i, len - 1, nums);
                isNextPermutation = true;
                break;
            }
        }
        if(!isNextPermutation) {
            Arrays.sort(nums);
        }
    }

    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int left, int right, int[] nums) {
        while(left < right) {
            swap(left, right, nums);
            left++;
            right--;
        }
    }
}
