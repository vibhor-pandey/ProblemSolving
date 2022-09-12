package Graph;

import java.util.ArrayList;
import java.util.List;

public class NumOfProvinces_QuickFindDisjointSet {
    private int[] root;

    private void init(int length) {
        root = new int[length];
        for(int i = 0; i < length; i++) {
            root[i] = i;
        }
    }

    public int findCircleNum(int[][] isConnected) {
        init(isConnected.length);
        //3) Continue 1 -> 2 for upper-right-triangular matrix to create disjoint set
        for(int i = 0; i < isConnected.length; i++) {
            for(int j = 0; j < isConnected.length; j++) {
                //1) Check for [i][j] is Connected?
                if(i < j && isConnected[i][j] == 1) {
                    //2) If Connected then Union by Rank for [i][j]
                    union(i, j);
                    // print();
                }
            }
        }
        //4) Number of distict root will be the distinct province
        return distinctProvince();
    }

    private int distinctProvince() {
        List<Integer> provinces = new ArrayList<>();
        for(int i = 0; i < root.length; i++) {
            if(!provinces.contains(root[i])) {
                provinces.add(root[i]);
            }
        }
        return provinces.size();
    }

    private int find(int x) {
        return root[x];
        // if(x == root[x]) {
        //     return x;
        // }
        // return root[x] = find(root[x]);
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY) {
            for(int i = 0; i < root.length; i++) {
                if(root[i] == rootY){
                    root[i] = rootX;
                }
            }
        }
        // if(root[rootX] != root[rootY]) {
        //     if(rank[rootX] > rank[rootY]) {
        //         root[rootY] = rootX;
        //     } else if(rank[rootX] < rank[rootY]) {
        //         root[rootX] = rootY;
        //     } else {
        //         root[rootY] = rootX;
        //         rank[rootX] += 1;
        //     }
        // }
    }


    private void print() {
        for(int i = 0; i < root.length; i++) {
            System.out.print(root[i] + ", ");
        }
        System.out.println();
    }
}
