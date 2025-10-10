import java.util.*;

class Pair {
    int first, second, time;
    public Pair(int f, int s, int t) {
        first = f;
        second = s;
        time = t;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int total = 0; 
        Queue<Pair> q = new LinkedList<>();

        // Count total oranges and add all initially rotten oranges to queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2)
                    q.add(new Pair(i, j, 0));
                if (grid[i][j] != 0)
                    total++;
            }
        }

        if (total == 0)
            return 0;  // no oranges

        int rotten = 0;
        int maxTime = 0;  // to store the last timestamp
        int dr[] = {0, 0, 1, -1};
        int dc[] = {1, -1, 0, 0};

        // BFS traversal
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int r = p.first, c = p.second, t = p.time;
            rotten++;
            maxTime = Math.max(maxTime, t);  // update time to latest rotten orange

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    q.add(new Pair(nr, nc, t + 1));
                }
            }
        }

        return rotten == total ? maxTime : -1;
    }
}
