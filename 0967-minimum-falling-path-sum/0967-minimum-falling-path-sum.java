class Solution {
  public int minFallingPathSum(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] dp = new int[m][n];

    // Base case: last row = same as matrix
    for (int j = 0; j < n; j++) {
      dp[m - 1][j] = matrix[m - 1][j];
    }

    // Fill from bottom-2 row up to top
    for (int i = m - 2; i >= 0; i--) {
      for (int j = 0; j < n; j++) {
        int left = Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;

        if (j > 0)
          left = matrix[i][j] + dp[i + 1][j - 1];
        down = matrix[i][j] + dp[i + 1][j];
        if (j < n - 1)
          right = matrix[i][j] + dp[i + 1][j + 1];

        dp[i][j] = Math.min(Math.min(left, down), right);
      }
    }

    int res = Integer.MAX_VALUE;
    for (int num : dp[0]) {
      res = Math.min(res, num);
    }

    return res;
  }
}
