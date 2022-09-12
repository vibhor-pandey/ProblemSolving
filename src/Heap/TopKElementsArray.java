package Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TopKElementsArray {

    private int size;
    private int capacity;
    private int[] heap;

    private void init(int k) {
        size = 0;
        capacity = k + 1;
        heap = new int[capacity];
        heap[0] = -1;
    }

    public int[] topKFrequent(int[] nums, int k) {
        init(k);
        for(int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
        return Arrays.copyOfRange(heap, 1, heap.length);
    }

    private void add(int num) {
        if(!isFull()) {
            size++;
            heap[size] = num;
            heapify(false);
        } else if(isFull() && num > heap[1]) {
            heap[1] = num;
            heapify(true);
        }
    }

    private void heapify(final boolean isTopDown) {
        if(size == 1) return;
        int index = size;
        int parent = index / 2;
        while(heap[index] < heap[parent] && index > 1 && !isTopDown) {
            int temp = heap[parent];
            heap[parent] = heap[index];
            heap[index] = temp;
            index = parent;
        }

        index = 1;
        while(index <= size / 2 && isTopDown) {
            int left = index * 2;
            int right = (index * 2) + 1;
            if((left <= size && heap[index] > heap[left]) || (right <= size && heap[index] > heap[right])) {
                if(right > size || heap[left] < heap[right]) {
                    int temp = heap[index];
                    heap[index] = heap[left];
                    heap[left] = temp;
                    index = left;
                } else {
                    int temp = heap[index];
                    heap[index] = heap[right];
                    heap[right] = temp;
                    index = right;
                }
            } else {
                break;
            }
        }
    }

    private boolean isFull() {
        return size == capacity - 1;
    }
}
