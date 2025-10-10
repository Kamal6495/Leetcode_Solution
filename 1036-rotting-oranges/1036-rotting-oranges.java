import java.util.*;

class Pair {
  int first, second;

  public Pair(int f, int s) {
    first = f;
    second = s;
  }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int total = 0; // total fresh + rotten oranges
        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2)
                    q.add(new Pair(i, j));
                if (grid[i][j] != 0)
                    total++;
            }
        }

        if (total == 0)
            return 0; // no oranges at all

        int time = 0;
        int rotten = q.size(); // initially rotten
        int dr[] = {0, 0, 1, -1};
        int dc[] = {1, -1, 0, 0};

        while (!q.isEmpty()) {
            int size = q.size();
            boolean change = false;
            for (int s = 0; s < size; s++) {
                Pair P = q.poll();
                int rr = P.first;
                int cc = P.second;
                for (int i = 0; i < 4; i++) {
                    int nr = rr + dr[i];
                    int nc = cc + dc[i];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        q.add(new Pair(nr, nc));
                        rotten++;
                        change = true;
                    }
                }
            }
            if (change)
                time++;
        }

        return rotten == total ? time : -1;
    }
}
