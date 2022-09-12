package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumMeetingRoomsPQ {

    private Queue<Pair<Integer, Integer>> heap;

    private void init() {
        heap = new PriorityQueue<>((x, y) -> x.getValue() - y.getValue());
    }

    public int minMeetingRooms(int[][] intervals) {
        init();
        //1) Sort intervals by Start Time
        sortIntervalByStartTime(intervals);
        //6) Continue 2 -> 5 for each interval
        for(int[] interval : intervals) {
            //2) Add the Intervals in Heap, where Key is End-Time
            //3) Check if room is free or not
            //4) If Free remove the top & add the Interval
            //5) If not then add Interval in the Heap
            findMeetingRoom(interval);
        }
        return heap.size();
    }

    private void findMeetingRoom(int[] interval) {
        if(heap.isEmpty() || heap.peek().getValue() > interval[0]) {
            heap.add(new Pair(interval[0], interval[1]));
        } else {
            heap.poll();
            heap.add(new Pair(interval[0], interval[1]));
        }
    }

    private void sortIntervalByStartTime(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);
    }

    private void print(int[][] intervals) {
        for(int[] interval : intervals) {
            System.out.print("(" + interval[0] + ", " + interval[1] + "), ");
        }
        System.out.println();
    }
}
