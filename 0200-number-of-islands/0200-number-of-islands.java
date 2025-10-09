class Pair {
  int first;
  int second;

  public Pair(int f, int s) {
    first = f;
    second = s;
  }

  public Pair() {
    first = 0;
    second = 0;
  }
}

class Solution {
  public int numIslands(char[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int cnt = 0;
    boolean vis[][] = new boolean[m][n];
    for (int row = 0; row < m; row++) {
      for (int col = 0; col < n; col++) {

        if (!vis[row][col] && grid[row][col] == '1') {
          cnt++;
          bfs(row, col, grid, vis);
        }
      }
    }
    return cnt;
  }

  public void bfs(int row, int col, char[][] grid, boolean vis[][]) {
    Queue<Pair> q = new LinkedList<>();
    q.add(new Pair(row, col));

    vis[row][col] = true;
    // Directions for 4 neighbors (diagonals not included)
    int[] dr = { 1, -1, 0, 0,  };
    int[] dc = { 0, 0, 1, -1,  };

    while (!q.isEmpty()) {
      Pair p = q.poll();

      int rw = p.first;
      int cl = p.second;
      // Negboring traversal 
      for (int i = 0; i < 4; i++) {
        int nwrow = rw + dr[i];
        int nwcol = cl + dc[i];

        if ((nwrow >= 0 && nwrow < grid.length && nwcol >= 0 && nwcol < grid[0].length) && !vis[nwrow][nwcol]
            && grid[nwrow][nwcol] == '1') {
          q.add(new Pair(nwrow, nwcol));
          vis[nwrow][nwcol] = true;
        }
      }
    }

  }

}