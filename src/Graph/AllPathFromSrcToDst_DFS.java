package Graph;

import java.util.ArrayList;
import java.util.List;

public class AllPathFromSrcToDst_DFS {
    private List<List<Integer>> paths;
    private int[][]             graph;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if(graph.length == 0) return new ArrayList<>();
        //1) Create ADJ List: graph (created)
        this.graph = graph;
        int src = 0;
        int dst = graph.length - 1;
        paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(src, path, dst);
        return paths;
    }

    private void backtrack(int current, List<Integer> path, int target) {
        // System.out.println("Start: " + Arrays.toString(path.toArray()));
        if(current == target) {
            // System.out.println("MATCH: " + Arrays.toString(path.toArray()));
            path.add(current);
            paths.add(new ArrayList<>(path));
            // System.out.println("GRAPH: " + graph[current].length);
            return;
        }
        // System.out.println("GRAPH: " + graph[current].length);
        path.add(current);
        for(int next : graph[current]) {
            // System.out.println("END: " + Arrays.toString(path.toArray()));
            backtrack(next, path, target);
            path.remove(path.size() - 1);
        }
    }
}
