package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllPathFromSrcToDst_BFS {
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
        bfs(src, path, dst);
        return paths;
    }

    private void bfs(int current, List<Integer> path, int target) {
        // paths = new ArrayList<>();
        Queue<List<Integer>> q = new LinkedList<>();
        // List<Integer> path = new ArrayList<>();
        path.add(0);
        q.add(path);

        while(!q.isEmpty()) {
            List<Integer> currentPath = q.poll();
            int node = currentPath.get(currentPath.size() - 1);
            for(int nextNode : graph[node]) {
                List<Integer> tempPath = new ArrayList<>(currentPath);
                tempPath.add(nextNode);
                if(nextNode == target) {
                    paths.add(new ArrayList<>(tempPath));
                } else {
                    q.add(new ArrayList<>(tempPath));
                }
            }
        }
    }
}
