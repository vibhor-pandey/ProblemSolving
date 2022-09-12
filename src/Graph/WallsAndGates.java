package Graph;

/**
 * You are given an m x n grid rooms initialized with these three possible values.
 *
 * -1 A wall or an obstacle.
 * 0 A gate.
 * INF Infinity means an empty room.
 * We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: rooms = [[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]
 * Output: [[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]
 * Example 2:
 *
 * Input: rooms = [[-1]]
 * Output: [[-1]]
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class WallsAndGates {

    //1) EMPTY ROOM = MAX VALUE
    //2) GATE = 0
    //3) INITIALIZE DIRECTION = [(-1,0), (0, 1), (1, 0), (0, -1)]
    //4) Find all the GATES
    //6) Use BFS & add distance for each empty room from GATE
    private static final int         EMPTY_ROOM = Integer.MAX_VALUE;
    private static final int         GATE       = 0;
    private static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[] {-1, 0},
            new int[] {0, 1},
            new int[] {1, 0},
            new int[] {0, -1}
    );


    public void wallsAndGates(int[][] rooms) {
        int rows = rooms.length;
        int cols = rooms[0].length;
        Queue<int[]> q = new LinkedList<>();

        //Find all the GATES
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(rooms[i][j] == GATE) {
                    q.add(new int[] {i, j});
                }
            }
        }

        while(!q.isEmpty()) {
            int[] rc = q.poll();
            int row = rc[0];
            int col = rc[1];

            for(int[] direction : DIRECTIONS) {
                int r = row + direction[0];
                int c = col + direction[1];
                if(r < 0 || c < 0 || r >= rows || c >= cols || rooms[r][c] != EMPTY_ROOM) {
                    continue;
                }
                rooms[r][c] = rooms[row][col] + 1;
                q.add(new int[] {r, c});
            }
        }
    }
}
