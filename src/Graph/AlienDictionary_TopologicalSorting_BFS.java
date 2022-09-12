package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class AlienDictionary_TopologicalSorting_BFS {
    //1) Create Graph [Node, List<Node>]
    //2) Create Map<Node, Count>
    //3) Build Graph & Store Count for each node
    //4) BFS
    //5) Add all Source Node in Queue (Nodes with Count->0)
    //6) Continue 7 -> 10 (Until Queue is Empty)
    //7) Poll from Queue & add in Answer List
    //8) Continue For each Neighbour, continue 9 -> 10
    //9) Decrease the neighbour Count
    //10) if(Count[neighbour] == 0) then Add in Queue

    private Map<Character, List<Character>> graph;
    private Map<Character, Integer>         count;

    private boolean buildGraph(String[] words) {
        graph = new HashMap<>();
        count = new HashMap<>();
        for(String word : words) {
            char[] wordChars = word.toCharArray();
            for(char c : wordChars) {
                graph.putIfAbsent(c, new ArrayList<>());
                count.put(c, 0);
            }

        }

        for(int itr = 0; itr < words.length - 1; itr++) {
            String word = words[itr];
            String nextWord = words[itr + 1];
            //If nextWord is Prefix of Word
            if(word.length() > nextWord.length() && word.startsWith(nextWord)) {
                return false;
            }
            // Find the first non match and insert the corresponding relation.
            for(int i = 0; i < Math.min(word.length(), nextWord.length()); i++) {
                if(word.charAt(i) != nextWord.charAt(i)) {
                    graph.get(word.charAt(i)).add(nextWord.charAt(i));
                    count.put(nextWord.charAt(i), count.get(nextWord.charAt(i)) + 1);
                    break;
                }
            }
        }
        return true;
    }

    public String alienOrder(String[] words) {
        if(!buildGraph(words)) {
            return "";
        }
        //Find all the Source Nodes
        Queue<Character> q = new LinkedList<>();
        for(char c : count.keySet()) {
            if(count.get(c) == 0) {
                q.add(c);
            }
        }

        //Start BFS
        StringBuilder answer = new StringBuilder();
        while(!q.isEmpty()) {
            char c = q.poll();
            answer.append(c);
            for(char next : graph.get(c)) {
                count.put(next, count.get(next) - 1);
                if(count.get(next) == 0) {
                    q.add(next);
                }
            }
        }
        if(answer.length() < count.size()) return "";
        return answer.toString();
    }
}
