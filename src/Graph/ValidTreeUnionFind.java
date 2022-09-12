package Graph;

public class ValidTreeUnionFind {

    private int[] root;
    private int[] rank;

    private void init(int n) {
        root = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1) return false;
        init(n);
        //1) For each Edge in edges continue 2 -> 3
        for(int i = 0; i < edges.length; i++) {
            //2) Find the root of (Ei, Ej)
            //3) Compute Union of (Ei, Ej) if root is same
            if(union(edges[i][0], edges[i][1])) {
                return false;
            }
        }
        return true;
    }

    private int findRoot(int node) {
        if(node == root[node]) {
            return node;
        }
        return root[node] = findRoot(root[node]);
    }

    private boolean union(int x, int y) {
        boolean hasCycle = false;
        int rootX = findRoot(x);
        int rootY = findRoot(y);
        if(rootX != rootY) {
            if(rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if(rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        } else {
            hasCycle = true;
        }
        return hasCycle;
    }
}
