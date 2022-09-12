package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class IsPathExists_BFS {

    private Map<Integer, List<Integer>> adjList;

    private void init(int n) {
        adjList = new HashMap<>(n);
        for(int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }
    }

    private void buildAdjacencyList(int[][] edges) {
        for(int[] edge : edges) {
            int src = edge[0];
            int dst = edge[1];
            adjList.get(src).add(dst);
            adjList.get(dst).add(src);
        }
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(n == 1) return true;
        init(n);
        //1) Build Adjancency List
        buildAdjacencyList(edges);
        //2) BFS
        return bfs(source, destination);
    }

    private boolean bfs(int src, int dst) {
        List<Integer> seen = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        while(!q.isEmpty()) {
            int vertex = q.poll();
            if(!seen.contains(vertex)) {
                for(int adjacent : adjList.get(vertex)) {
                    if(adjacent == dst) return true;
                    q.add(adjacent);
                }
            }
            seen.add(vertex);
        }
        return false;
    }
}
