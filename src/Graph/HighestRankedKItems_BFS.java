package Graph;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class HighestRankedKItems_BFS {
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        //1) PQ<int[]>: {Distance, Price, Row, Col} with Comparator
        //2) List<int[]> Output
        //3) Push start in PQ: {0, price, start[0], start[1]}
        //4) While PQ is not Empty
        //5)    Curr {D, P, R, C} = PQ.Poll()
        //6)    if Curr is not Wall && not Empty Cell && Within Price Range
        //7)        output.add(new int[] {D, P, R, C})
        //8)    For Each Direction
        //9)        if curr.neighbor is within the Grid
        //10)           PQ.offer(neighborD, neighborP, neighborR, neighborC)

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            else if (a[1] != b[1]) return a[1] - b[1];
            else if (a[2] != b[2]) return a[2] - b[2];
            else return a[3] - b[3];
        });

        List<List<Integer>> output = new ArrayList<>();
        int[][] DIRECTIONS = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        if(grid[start[0]][start[1]] == 0) return new ArrayList<>();
        pq.offer(new int[] {0, grid[start[0]][start[1]], start[0], start[1]});
        while (!pq.isEmpty() && k > 0) {
            int[] current = pq.poll();
            if(grid[current[2]][current[3]] != 0 && current[1] != 1 && current[1] >= pricing[0] && current[1] <= pricing[1]) {
                output.add(List.of(current[2], current[3]));
                --k;
            }

            for(int[] direction : DIRECTIONS) {
                int row = current[2] + direction[0];
                int col = current[3] + direction[1];
                if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
                    continue;
                }
                pq.offer(new int[] {current[0] + 1, grid[row][col], row, col});
            }
            grid[current[2]][current[3]] = 0;
        }

        return output;
    }
}
