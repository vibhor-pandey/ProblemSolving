package Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Use BFS
 * Neighbor of String: all possible value in String at each index
 */
//1)  Create a set for visited words
//2) Intialize Level = 0
//3) Create a Queue for BFS
//4) Remove BeginWord from Visited
//5) Add BeginWord in Queue
//6) Iterate until Queue != Empty
//7) Size of the Queue & Increment Level
//6) Iterate for Size of the current Queue
//7)    Poll the word from Queue
//8)    If polled word == endWord return level
//9)    Get Neighbors(Polled_word)
//10)   Iterate for each neighbor
//10)       if(visited[neighbor])
//11)           Remove neighbor from visited
//12)           Add neighbor in Queue
//13) return 0;
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> seen = new HashSet<>(wordList);
        if(!seen.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        int level = 0;
        seen.remove(beginWord);
        q.add(beginWord);

        while(!q.isEmpty()) {
            int size = q.size();
            level++;
            for(int i = 0; i < size; i++) {
                String curr = q.poll();
                if(curr.equals(endWord)) return level;
                List<String> neighbors = getNeighbors(curr);
                for(String neighbor : neighbors) {
                    if(seen.contains(neighbor)) {
                        seen.remove(neighbor);
                        q.add(neighbor);
                    }
                }
            }
        }
        return 0;
    }

    private List<String> getNeighbors(String word) {
        List<String> neighbors = new ArrayList<>();
        char[] c = word.toCharArray();
        for(int i = 0; i < c.length; i++) {
            char temp = c[i];
            for(char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
                c[i] = alphabet;
                String neighbor = new String(c);
                neighbors.add(neighbor);
            }
            c[i] = temp;
        }
        return neighbors;
    }
}
