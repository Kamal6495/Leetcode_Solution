class Solution {
  public int minPathSum(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int prev[] = new int[n];
    Arrays.fill(prev,0);
    for (int i = 0; i < m; i++) {
      int curr[] = new int[n];
      curr[0] = grid[i][0];
      for (int j = 0; j < n; j++) {
        if (i == 0 && j == 0) {
          continue;
        }
        int left = Integer.MAX_VALUE;
        int top = Integer.MAX_VALUE;
        if (i > 0)
          top = grid[i][j] + prev[j];
        if (j > 0)
          left = grid[i][j] + curr[j - 1];

        curr[j] = Math.min(top, left);

      }

      prev = curr;

    }
    return prev[n - 1];
  }

}