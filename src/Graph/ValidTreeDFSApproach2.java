package Graph;

import java.util.*;

public class ValidTreeDFSApproach2 {

    private List<List<Integer>> adjList;
    // private Map<Integer, Integer> parent;
    private Set<Integer>        visited;

    private void init(int n) {
        adjList = new ArrayList<>(n);
        visited = new HashSet<>();
        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    private void createAdjList(int[][] edges) {
        for(int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
    }

    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1) return false;
        init(n);
        //1) Create adjaceny list
        createAdjList(edges);
        //2) Push 0th node in the Stack
        Stack<Integer> s = new Stack<>();
        s.push(0);
        visited.add(0);
        //3) Continue 4 -> X until Stack is Empty
        while(!s.isEmpty()) {
            //4) Pop Node from Stack
            int node = s.pop();
            //5) For each neighbour continue 6 -> Y
            for(int neighbour : adjList.get(node)) {
                //6) If parent(node) == neighbour continue (Visited)
                if(visited.contains(neighbour)) {
                    continue;
                }
                //8) Push neighbour in Stack
                s.push(neighbour);
                //9) Put (neighbour) in Visited
                visited.add(neighbour);
            }
        }
        //10) Return True if parent.size() == Number of Nodes (Valid Tree)
        return visited.size() == n;
    }
}

