class Solution {
  public int uniquePathsWithObstacles(int[][] arr) {
    int m = arr.length;
    int n = arr[0].length;
    int dp[][] = new int[m][n];
    if (arr[0][0] == 1)
      return 0;
    dp[0][0] = 1;

    for (int i = 1; i < m; i++) {//Row
      if (arr[i][0] == 1)
        dp[i][0] = 0;
      else
        dp[i][0] = dp[i - 1][0];
    }
    for (int i = 1; i < n; i++) {//Column
      if (arr[0][i] == 1)
        dp[0][i] = 0;
      else
        dp[0][i] = dp[0][i - 1];
    }

    for (int i = 1; i < m; i++) {

      for (int j = 1; j < n; j++) {
        if (arr[i][j] == 1) {
          dp[i][j] = 0;
          continue;
        }
        int left = 0, right = 0;
        if (i > 0)
          left = dp[i - 1][j];
        if (i > 0)
          right = dp[i][j - 1];
        dp[i][j] = left + right;
      }
    }
    return dp[m - 1][n - 1];
  }
}