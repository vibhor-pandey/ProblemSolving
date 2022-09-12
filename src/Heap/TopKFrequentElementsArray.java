package Heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TopKFrequentElementsArray {

    private int                   size;
    private int                   capacity;
    private int[]                 heap;
    private Map<Integer, Integer> numCount;

    private void init(int k) {
        size = 0;
        capacity = k + 1;
        heap = new int[capacity];
        heap[0] = -1;
        numCount = new HashMap<>();
    }

    private void createNumCountMap(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            numCount.put(nums[i],
                         numCount.containsKey(nums[i]) ? numCount.get(nums[i]) + 1 : 1);
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        init(k);
        createNumCountMap(nums);
        // printMap();
        for(int num : numCount.keySet()) {
            add(num);
        }
        return Arrays.copyOfRange(heap, 1, heap.length);
    }

    private void add(int num) {
        if(!isFull()) {
            size++;
            heap[size] = num;
            heapify(false);
        } else if(isFull() && numCount.get(num) > numCount.get(heap[1])) {
            heap[1] = num;
            heapify(true);
        }
        // print();
    }

    private void heapify(final boolean isTopDown) {
        if(size == 1) return;
        int index = size;
        int parent = index / 2;
        while(index > 1 && numCount.get(heap[index]) < numCount.get(heap[parent]) && !isTopDown) {
            int temp = heap[parent];
            heap[parent] = heap[index];
            heap[index] = temp;
            index = parent;
            parent = index / 2;
        }

        index = 1;
        while(index <= size / 2 && isTopDown) {
            int left = index * 2;
            int right = (index * 2) + 1;
            if((left <= size && numCount.get(heap[index]) > numCount.get(heap[left])) || (right <= size && numCount.get(heap[index]) > numCount.get(heap[right]))) {
                if(right > size || numCount.get(heap[left]) < numCount.get(heap[right])) {
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

    private void print() {
        for(int i = 0; i < heap.length; i++) {
            System.out.print(heap[i] + ", ");
        }
        System.out.println();
    }

    private void printMap() {
        for(int num : numCount.keySet()) {
            System.out.print(num + ": " + numCount.get(num) + ", ");
        }
        System.out.println();
    }
}