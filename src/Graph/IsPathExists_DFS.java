package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class IsPathExists_DFS  {

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
        //2) DFS
        return dfs(source, destination);
    }

    private boolean dfs(int src, int dst) {
        List<Integer> seen = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        s.push(src);

        while(!s.isEmpty()) {
            int vertex = s.pop();
            if(!seen.contains(vertex)) {
                seen.add(vertex);
                for(int adjacent : adjList.get(vertex)) {
                    if(adjacent == dst) return true;
                    s.push(adjacent);
                }
            }
        }
        return false;
    }
}
