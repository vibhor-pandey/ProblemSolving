package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

//Time complexity: O(N+ElogN)
//Space complexity: O(N + E)
public class NetworkDelay_WeightedGraph_Dijkstra_PQ {

    private Map<Integer, List<Pair<Integer, Integer>>> graph;
    private int[] signalRecievedAt;

    public int networkDelayTime(int[][] times, int n, int k) {
        if(times.length == 0) return -1;
        //1) Build Graph by Adjacency List [Node, [Time, NextNode]]
        //2) Sort Neighbors by Time
        buildGraph(times, n);
        //3) Create SingalRecievedAt[Node]
        signalRecievedAt = new int[n + 1];
        Arrays.fill(signalRecievedAt, Integer.MAX_VALUE);
        //3) Traverse Graph using Dijkstra (Priority Queue)
        //PQ: <Time, Node>
        //4) While Traversing check if SingalRecievedAt[Node] > CurrentTime
        dijkstra(k);
        // print(signalRecievedAt);
        int minTime = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++) {
            minTime = Math.max(minTime, signalRecievedAt[i]);
        }
        return minTime == Integer.MAX_VALUE ? -1 : minTime;
    }

    private void buildGraph(int[][] times, int n) {
        graph = new HashMap<>(n);
        for(int[] time : times) {
            int src = time[0];
            int dst = time[1];
            int travelTime = time[2];
            if(!graph.containsKey(src)) {
                graph.put(src, new ArrayList<>());
            }
            graph.get(src).add(new Pair(travelTime, dst));
        }
    }

    private void dijkstra(int k) {
        Queue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getKey() - b.getKey());
        pq.add(new Pair(0, k));
        signalRecievedAt[k] = 0;

        while(!pq.isEmpty()) {
            Pair<Integer, Integer> curr = pq.remove();
            int currNode = curr.getValue();
            int currTime = curr.getKey();
            if(currTime > signalRecievedAt[currNode]) continue;
            if(!graph.containsKey(currNode)) continue;
            for(Pair<Integer, Integer> next : graph.get(currNode)) {
                int time = next.getKey();
                int nextNode = next.getValue();
                int arrivalTime = time + currTime;
                if(signalRecievedAt[nextNode] > arrivalTime) {
                    signalRecievedAt[nextNode] = arrivalTime;
                    pq.add(new Pair(signalRecievedAt[nextNode], nextNode));
                }
            }
        }
    }

    private void print(int[] arr) {
        for(int num : arr) {
            System.out.print(num + ", ");
        }
        System.out.println();
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
}
