class Solution {
  public int uniquePaths(int m, int n) {
    int dp[][] = new int[m][n];
    // Initialize first row and column
    for (int i = 0; i < m; i++)
      dp[i][0] = 1;
    for (int j = 0; j < n; j++)
      dp[0][j] = 1;
    //Iterative Reverse
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        int left = 0, right = 0;
        if (i > 0)
          left = dp[i - 1][j];
        if (j > 0)
          right = dp[i][j - 1];
        dp[i][j] = left + right;
      }
    }
    return dp[m - 1][n - 1];
  }

}