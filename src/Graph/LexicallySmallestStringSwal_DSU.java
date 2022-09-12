package Graph;

/**
 * You are given a string s, and an array of pairs of indices in the string pairs where pairs[i] = [a, b] indicates 2 indices(0-indexed) of the string.
 *
 * You can swap the characters at any pair of indices in the given pairs any number of times.
 *
 * Return the lexicographically smallest string that s can be changed to after using the swaps.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "dcab", pairs = [[0,3],[1,2]]
 * Output: "bacd"
 * Explaination:
 * Swap s[0] and s[3], s = "bcad"
 * Swap s[1] and s[2], s = "bacd"
 * Example 2:
 *
 * Input: s = "dcab", pairs = [[0,3],[1,2],[0,2]]
 * Output: "abcd"
 * Explaination:
 * Swap s[0] and s[3], s = "bcad"
 * Swap s[0] and s[2], s = "acbd"
 * Swap s[1] and s[2], s = "abcd"
 * Example 3:
 *
 * Input: s = "cba", pairs = [[0,1],[1,2]]
 * Output: "abc"
 * Explaination:
 * Swap s[0] and s[1], s = "bca"
 * Swap s[1] and s[2], s = "bac"
 * Swap s[0] and s[1], s = "abc"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 10^5
 * 0 <= pairs.length <= 10^5
 * 0 <= pairs[i][0], pairs[i][1] < s.length
 * s only contains lower case English letters.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LexicallySmallestStringSwal_DSU {

    Map<Integer, List<Integer>> rootAndComponent;
    List<Integer> cIndices;

    private int[] root;
    private int[] rank;

    private void init(int length) {
        root = new int[length];
        rank = new int[length];
        for(int i = 0; i < length; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        init(s.length());
        //1) Create all the components
        for(List<Integer> pair : pairs) {
            int x = pair.get(0);
            int y = pair.get(1);
            connect(s, x, y);
        }

        //2) Create ROOT: [INDICES] Map
        rootAndComponent = new HashMap<>();
        for(int i = 0; i < root.length; i++) {
            int rootI = find(i);
            if(!rootAndComponent.containsKey(rootI)) {
                List<Integer> vertices = new ArrayList<>();
                vertices.add(i);
                rootAndComponent.put(rootI, vertices);
            } else {
                rootAndComponent.get(rootI).add(i);
            }
        }

        //3) Sort Indices & Characters, And place in string
        char[] smallestString = new char[s.length()];
        for(List<Integer> indices : rootAndComponent.values()) {
            List<Character> c = new ArrayList<>(indices.size());
            for(int index : indices) {
                c.add(s.charAt(index));
            }
            Collections.sort(c);
            for(int index = 0; index < c.size(); index++) {
                smallestString[indices.get(index)] = c.get(index);
            }
        }
        return String.valueOf(smallestString);
    }

    private int find(int node) {
        if(node == root[node]) {
            return node;
        }
        return node = find(root[node]);
    }

    private void connect(String s, int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY) {
            if(rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if(rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += rank[rootY];
            }
        }
    }
}
