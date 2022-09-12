package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseSchedule_TopologicalSorting_BFS {

    private Map<Integer, List<Integer>> graph;
    private int[]                       inDegree;
    private List<Integer>               order;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0 && numCourses == 0) return null;
        //1) Build graph by creating Adjancency List (Directed)
        buildGraph(numCourses, prerequisites);
        //2) Find courses with IN-DEGREE = 0
        inDegreeOfNodes();
        //3) Start Traversing from Source(BFS)
        //4) Mark Node Visited
        //5) Traverse next_course dependent on current course & reduce inDegree[next_course] by 1
        //6) If inDegree[next_course] then Add in the Queue
        bfs(numCourses);
        //4) Check if there is any node with InDegree > 1
        for(int degree : inDegree) {
            if(degree > 0) {
                return new int[0];
            }
        }
        return order.stream().mapToInt(Integer::intValue).toArray();
    }

    private void buildGraph(int courses, int[][] prerequisites) {
        graph = new HashMap<>(courses);
        for(int course = 0; course < courses; course++) {
            graph.put(course, new ArrayList<>());
        }
        for(int[] prerequisite : prerequisites) {
            int firstCourse = prerequisite[1];
            int nextCourse = prerequisite[0];
            graph.get(firstCourse).add(nextCourse);
        }
    }

    private void inDegreeOfNodes() {
        inDegree = new int[graph.size()];
        for(List<Integer> courses : graph.values()) {
            for(int course : courses) {
                inDegree[course] += 1;
            }
        }
    }

    private void bfs(int courses) {
        List<Integer> visited = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        order = new ArrayList<>();
        for(int i = 0; i < inDegree.length; i++) {
            if(inDegree[i] == 0) {
                q.add(i);
            }
        }
        if(q.size() == 0) {
            return;
        }

        while(!q.isEmpty()) {
            int preCourse = q.poll();
            visited.add(preCourse);
            order.add(preCourse);
            for(int next : graph.get(preCourse)) {
                inDegree[next] -= 1;
                if(inDegree[next] == 0) {
                    q.add(next);
                }
            }
        }
    }
}
