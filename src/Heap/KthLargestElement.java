package Heap;

import java.util.PriorityQueue;

public class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i< nums.length; i++) {
            if(heap.size() == k) {
                if (heap.peek() < nums[i]) {
                    heap.poll();
                    heap.add(nums[i]);
                }
            } else {
                heap.add(nums[i]);
            }
        }
        return heap.peek();
    }
}
