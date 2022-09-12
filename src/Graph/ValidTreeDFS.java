package Graph;

/**
 * You have a graph of n nodes labeled from 0 to n - 1.
 * You are given an integer n and a list of edges where edges[i] = [ai, bi] indicates that there is an undirected edge between nodes ai and bi in the graph.
 *
 * Return true if the edges of the given graph make up a valid tree, and false otherwise.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
 * Output: true
 * Example 2:
 *
 *
 * Input: n = 5, edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= n <= 2000
 * 0 <= edges.length <= 5000
 * edges[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * There are no self-loops or repeated edges.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ValidTreeDFS {

    private List<List<Integer>>   adjList;
    private Map<Integer, Integer> parent;

    private void init(int n) {
        adjList = new ArrayList<>(n);
        parent = new HashMap<>();
        parent.put(0, -1);
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
        init(n);
        //1) Create adjaceny list
        createAdjList(edges);
        //2) Push 0th node in the Stack
        Stack<Integer> s = new Stack<>();
        s.push(0);
        //3) Continue 4 -> X until Stack is Empty
        while(!s.isEmpty()) {
            //4) Pop Node from Stack
            int node = s.pop();
            //5) For each neighbour continue 6 -> Y
            for(int neighbour : adjList.get(node)) {
                //6) If parent(node) == neighbour continue (Visited)
                if(parent.get(node) == neighbour) {
                    continue;
                }
                //7) If parent contains neighbour return false (Cycle)
                if(parent.containsKey(neighbour)) {
                    return false;
                }
                //8) Push neighbour in Stack
                s.push(neighbour);
                //9) Put (neighbour, node) in Parent
                parent.put(neighbour, node);
            }
        }
        //10) Return True if parent.size() == Number of Nodes (Valid Tree)
        return parent.size() == n;
    }
}

