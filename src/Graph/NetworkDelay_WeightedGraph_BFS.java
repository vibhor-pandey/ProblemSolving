package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

//Time complexity: O(N * E)
//Space complexity: O(N * E)
public class NetworkDelay_WeightedGraph_BFS {

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
        //3) Traverse Graph using BFS
        //4) While Traversing for next node check if SingalRecievedAt[NextNode] > CurrentTime
        BFS(k);
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

        for(int node : graph.keySet()) {
            Collections.sort(graph.get(node), (a, b) -> a.getKey() - b.getKey());
        }
    }

    private void BFS(int k) {
        Queue<Integer> s = new LinkedList<>();
        s.add(k);
        signalRecievedAt[k] = 0;

        while(!s.isEmpty()) {
            int curr = s.poll();
            if(!graph.containsKey(curr)) continue;
            for(Pair<Integer, Integer> next : graph.get(curr)) {
                int time = next.getKey();
                int nextNode = next.getValue();
                int arrivalTime = time + signalRecievedAt[curr];
                if(signalRecievedAt[nextNode] > arrivalTime) {
                    signalRecievedAt[nextNode] = arrivalTime;
                    s.add(nextNode);
                }
            }
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
}
