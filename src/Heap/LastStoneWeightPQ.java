package Heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class LastStoneWeightPQ {

    private Queue<Pair<Integer, Integer>> heap;
    private int                           size;

    private void init(int capacity) {
        heap = new PriorityQueue<>((x, y) -> x.getKey() - y.getKey());
        size = capacity;
    }

    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1) return stones[0];

        init(stones.length);
        while(size > 0) {
            //1) Pick two heavy stones (using Heap of size 2)
            for(int i = 0; i < stones.length; i++) {
                add(stones[i], i);
            }
            //2) Break the picked up stones
            //3) Put the result in the array
            breakStones(stones);
            //4) continue 1 - 3 till the last stone or no stone left
        }
        // printArray(stones);
        return getLastRemainingWeight(stones);
    }

    private int getLastRemainingWeight(int[] stones) {
        int weight = 0;
        for(int stone : stones) {
            weight += stone;
        }
        return weight;
    }

    private void breakStones(int[] stones) {
        Pair<Integer, Integer> x = heap.poll();
        Pair<Integer, Integer> y = heap.poll();
        int smash = y.getKey() - x.getKey();
        stones[x.getValue()] = 0;
        if(smash > 0) {
            stones[y.getValue()] = smash;
        } else {
            stones[y.getValue()] = 0;
        }
        size--;
    }

    private void add(int stone, int index) {
        if(!isFull()) {
            heap.add(new Pair<Integer, Integer>(stone, index));
        } else {
            if(heap.peek().getKey() < stone) {
                heap.poll();
                heap.add(new Pair<Integer, Integer>(stone, index));
            }
        }
        // print();
    }

    private boolean isFull() {
        return heap.size() == 2;
    }

    private void print() {
        for(Pair<Integer, Integer> pair : heap) {
            System.out.print(pair.getKey() + ", ");
        }
        System.out.println();
    }

    private void printArray(int[] arr) {
        for(int num : arr) {
            System.out.print(num + ", ");
        }
        System.out.println();
    }
}


class Pair<T, K> {
    T key;
    K value;

    Pair(T key, K value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return this.key;
    }

    public K getValue() {
        return this.value;
    }
}