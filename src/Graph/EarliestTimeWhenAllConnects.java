package Graph;

import java.util.Arrays;

public class EarliestTimeWhenAllConnects {

    //1) Create ROOT[VERTEX]: Root/Parent of Vertex
    private int[] root;
    //2) Create RANK[VERTEX]: Height of Vertex
    private int[] rank;

    private int earliestTime;
    private int groups;

    private void init(int n) {
        root = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++) {
            root[i] = i;
            rank[i] = 1;
        }
        earliestTime = -1;
        groups = n;
    }

    public int earliestAcq(int[][] logs, int n) {
        // if(logs.length != n - 1) return -1;
        init(n);
        Arrays.sort(logs, (x, y) -> x[0] - y[0]);
        for(int i = 0; i < logs.length; i++) {
            int timestamp = logs[i][0];
            int x = logs[i][1];
            int y = logs[i][2];
            //3) Find(X): Find root of vertex X
            //4) Union(X, Y): Create edge b/w Vertex X & Y
            if(!makeFriend(x, y)) {
                earliestTime = timestamp;
            }
            //5) Continue 3 -> 4 For each logs
        }
        if (groups != 1) {
            return -1;
        }
        return earliestTime;
    }

    private int findRoot(int node) {
        if(node == root[node]) {
            return node;
        }
        return node = findRoot(root[node]);
    }

    private boolean makeFriend(int x, int y) {
        int rootX = findRoot(x);
        int rootY = findRoot(y);
        boolean isAcq = false;
        if(rootX != rootY) {
            if(rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if(rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rootX += 1;
            }
            groups--;
        } else {
            isAcq = true;
        }
        return isAcq;
    }
}
