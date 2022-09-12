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
import java.util.List;
import java.util.Stack;

public class LexicallySmallestStringSwap_DFSIterative  {

    List<List<Integer>> adjList;
    List<Integer>       visited;
    List<Character>     characters;
    List<Integer>       cIndices;

    private void init(int length) {
        adjList = new ArrayList<>();
        visited = new ArrayList<>();
        for(int i = 0; i < length; i++) {
            adjList.add(new ArrayList<Integer>());
        }
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        init(s.length());
        //1) Build Adjenancy List
        for(List<Integer> pair : pairs) {
            int source = pair.get(0);
            int destination = pair.get(1);
            adjList.get(source).add(destination);
            adjList.get(destination).add(source);
        }
        char[] smallString = new char[s.length()];
        for(int i = 0; i < s.length(); i++) {
            //2) Perform DFS
            if(visited.contains(i)) continue;

            characters = new ArrayList<>();
            cIndices = new ArrayList<>();
            DFS(s, i);
            //3) Sort the Characters in the Component
            Collections.sort(characters);
            // printChar(characters);
            Collections.sort(cIndices);
            // printIndices(cIndices);
            //4) Store the sorted Characters

            for(int index = 0; index < characters.size(); index++) {
                smallString[cIndices.get(index)] = characters.get(index);
            }
            //5) Continue 2 -> 4 for each verted in ADJ List
        }
        return String.valueOf(smallString);
    }

    private void DFS(String s, int vertex) {
        Stack<Integer> stack = new Stack<>();
        stack.push(vertex);
        visited.add(vertex);
        characters.add(s.charAt(vertex));
        cIndices.add(vertex);

        while(!stack.isEmpty()) {
            int node = stack.pop();
            for(int adjacent : adjList.get(node)) {
                if(!visited.contains(adjacent)) {
                    stack.push(adjacent);
                    visited.add(adjacent);
                    characters.add(s.charAt(adjacent));
                    cIndices.add(adjacent);
                }
            }
        }
    }

    private void print(List<List<Integer>> adjList) {
        for(List<Integer> adj : adjList) {
            for(int n : adj) {
                System.out.print(n + ", ");
            }
            System.out.println();
        }
    }

    private void printChar(List<Character> cs) {
        for(Character c : cs) {
            System.out.print(c + ", ");
        }
        System.out.println();
    }
    private void printIndices(List<Integer> cs) {
        for(int c : cs) {
            System.out.print(c + ", ");
        }
        System.out.println();
    }
}
