package Heap;

public class KthLargestArray {

    private int capacity;
    private int size;
    private int[] heap;

    private void init(int k) {
        capacity = k + 1;
        size = 0;
        heap = new int[capacity];
        heap[0] = -1;
    }

    public int findKthLargest(int[] nums, int k) {
        init(k);
        for(int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
        return heap[1];
    }

    private void add(int num) {
        //2nd Heap is full
        if(isFull() && num > heap[1]) {
            heap[1] = num;
            heapify(true);
        }
        //1st Heap is not full
        if(!isFull()) {
            size++;
            heap[size] = num;
            heapify(false);
        }
    }

    private void heapify(boolean isTopDown) {
        if (size == 1) return;
        int index = size;
        int parent = index / 2;
        while(heap[index] < heap[parent] && index > 1 && !isTopDown) {
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

            if((left <= size && heap[index] > heap[left]) || (right <= size && heap[index] > heap[right])) {
                if(heap[left] < heap[right]) {
                    int temp = heap[left];
                    heap[left] = heap[index];
                    heap[index] = temp;
                    index = left;
                } else {
                    int temp = heap[right];
                    heap[right] = heap[index];
                    heap[index] = temp;
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
