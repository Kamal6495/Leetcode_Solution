class Solution {
  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    int oldColor = image[sr][sc];
    if (oldColor == color)
      return image; // nothing to do

    boolean[][] vis = new boolean[image.length][image[0].length];
    dfs(image, sr, sc, color, oldColor, vis);
    return image;

  }

  public void dfs(int[][] arr, int row, int col, int newcolor,int oldcolor, boolean vis[][]) {
    vis[row][col] = true;
    arr[row][col]=newcolor;
    int dr[] = { 1, 0, 0, -1 };
    int dc[] = { 0, 1, -1, 0 };

        for (int ii = 0; ii < 4; ii++) {
          int nr = row + dr[ii];
          int nc = col + dc[ii];

          if ((nr >= 0 && nr < arr.length && nc >= 0 && nc < arr[0].length) && !vis[nr][nc] && arr[nr][nc] == oldcolor) {
            arr[nr][nc] = newcolor;
            vis[nr][nc] = true;
            dfs(arr, nr, nc, newcolor,oldcolor, vis);
          }
        }


  }
}