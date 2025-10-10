class Pair {
  int first, second;

  public Pair(int f, int s) {
    first = f;
    second = s;
  }
}

class Solution {
  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    int oldColor = image[sr][sc];
    if (oldColor == color)
      return image; // nothing to do

    boolean[][] vis = new boolean[image.length][image[0].length];
    bfs(image, sr, sc, color, oldColor, vis);
    return image;

  }

  public void bfs(int[][] arr, int row, int col, int newcolor, int oldcolor, boolean vis[][]) {
    Queue<Pair> q = new LinkedList<>();
    q.add(new Pair(row, col));
    int dr[] = { 1, 0, 0, -1 };
    int dc[] = { 0, 1, -1, 0 };
    vis[row][col] = true;
    arr[row][col] = newcolor;
    while (!q.isEmpty()) {
      Pair p = q.poll();
      int rr = p.first;
      int cc = p.second;

      for (int ii = 0; ii < 4; ii++) {
        int nr = rr + dr[ii];
        int nc = cc + dc[ii];

        if ((nr >= 0 && nr < arr.length && nc >= 0 && nc < arr[0].length) && !vis[nr][nc] && arr[nr][nc] == oldcolor) {
          q.add(new Pair(nr, nc));
          arr[nr][nc] = newcolor;
          vis[nr][nc] = true;

        }
      }
    }

  }

  public void dfs(int[][] arr, int row, int col, int newcolor, int oldcolor, boolean vis[][]) {
    vis[row][col] = true;
    arr[row][col] = newcolor;
    int dr[] = { 1, 0, 0, -1 };
    int dc[] = { 0, 1, -1, 0 };

    for (int ii = 0; ii < 4; ii++) {
      int nr = row + dr[ii];
      int nc = col + dc[ii];

      if ((nr >= 0 && nr < arr.length && nc >= 0 && nc < arr[0].length) && !vis[nr][nc] && arr[nr][nc] == oldcolor) {
        arr[nr][nc] = newcolor;
        vis[nr][nc] = true;
        dfs(arr, nr, nc, newcolor, oldcolor, vis);
      }
    }

  }
}