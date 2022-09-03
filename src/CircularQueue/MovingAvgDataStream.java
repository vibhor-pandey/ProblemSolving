package CircularQueue;

/**
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 *
 * Implement the MovingAverage class:
 *
 * MovingAverage(int size) Initializes the object with the size of the window size.
 * double next(int val) Returns the moving average of the last size values of the stream.
 *
 *
 * Example 1:
 *
 * Input
 * ["MovingAverage", "next", "next", "next", "next"]
 * [[3], [1], [10], [3], [5]]
 * Output
 * [null, 1.0, 5.5, 4.66667, 6.0]
 *
 * Explanation
 * MovingAverage movingAverage = new MovingAverage(3);
 * movingAverage.next(1); // return 1.0 = 1 / 1
 * movingAverage.next(10); // return 5.5 = (1 + 10) / 2
 * movingAverage.next(3); // return 4.66667 = (1 + 10 + 3) / 3
 * movingAverage.next(5); // return 6.0 = (10 + 3 + 5) / 3
 */

import java.util.ArrayList;
import java.util.List;

class MovingAvgDataStream {

    private int           size;
    private List<Integer> queue;
    private int           head;
    private int           tail;
    private double        average;

    public MovingAvgDataStream(int size) {
        this.size = size;
        this.queue = new ArrayList<>(size);
        head = -1;
        tail = -1;
    }

    public double next(int value) {
        double average = 0;
        if(queue.size() == 0) {
            queue.add(value);
            head = 0;
            tail = 0;
        } else if(queue.size() == size) {
            queue.set(head, value);
            tail = head;
            head = (head + 1) % size;
        } else {
            tail = (tail + 1) % size;
            queue.add(value);
        }
        for(int num : queue) {
            average += num;
        }
        return average/queue.size();
    }

    private void print() {
        for(int i = 0; i < queue.size(); i++) {
            if(i == head) {
                System.out.print(queue.get(i) + "(HEAD), ");
                continue;
            } else if(i == tail) {
                System.out.print(queue.get(i) + "(TAIL), ");
                continue;
            }
            System.out.print(queue.get(i) + ", ");
        }
        System.out.println();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */