package Arrays;

/**
 * You are given an integer array height of length n.
 * There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
 * In this case, the max area of water (blue section) the container can contain is 49.
 * Example 2:
 *
 * Input: height = [1,1]
 * Output: 1
 *
 *
 * Constraints:
 *
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 */

public class ContainerWithMostWater {

    /**
     * Time Complexity: O(N^2)
     * Space Complexity: O(1)
     * @param height
     * @return
     */
     public int maxAreaBruteForce(int[] height) {
         int maxArea = 0;
         for(int x = 0; x < height.length; x++) {
             for(int y = x + 1; y < height.length; y++) {
                 int area = Math.abs(x - y) * Math.min(height[x], height[y]);
                 maxArea = Math.max(maxArea, area);
             }
         }
         return maxArea;
     }

    /**
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * @param height
     * @return
     */
    /**
     * 1) Two Pointers (left = 0 & right = len - 1)
     * 2) Calculate Area = L X B : ABS(left - right) * MAX(height[left], height[right])
     * 3) Pick MaxArea
     * 4) if (height[left] > height[right]) left++
     * 5) Else right++
     * 6) Continue 2 -> 5 till left < right
     */
    public int maxAreaOptimized(int[] height) {
        int maxArea = 0;
        int x = 0;
        int y = height.length - 1;

        while(x < y) {
            int area = Math.abs(x - y) * Math.min(height[x], height[y]);
            maxArea = Math.max(maxArea, area);
            if(height[x] > height[y]) {
                y--;
            } else {
                x++;
            }
        }
        return maxArea;
    }
}
