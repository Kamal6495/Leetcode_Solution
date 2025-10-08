class Solution {
  public int uniquePathsWithObstacles(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int prev[] = new int[n];
    int dp[][] = new int[m][n];
    if (grid[0][0] == 1)
      return 0;
    prev[0] = 1;//Initail

    for (int i = 0; i < m; i++) {
      int curr[] = new int[n];
      curr[0] = 1;
      for (int j = 0; j < n; j++) {
        if (i == 0 && j == 0)
          continue;
        if (grid[i][j] == 1)
          curr[j] = 0;
        else {
          int left = 0, right = 0;
          if (i > 0)
            left = prev[j];
          if (j > 0)
            right = curr[j - 1];

          curr[j] = left + right;
        }
      }
      prev = curr;
    }

    return prev[n - 1];
  }
}