class Solution {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    int memo[][] = new int[m][n];
    for (int i = 0; i < m; i++)
      Arrays.fill(memo[i], -1);
    return f(m - 1, n - 1, obstacleGrid, memo);
  }

  public int f(int m, int n, int arr[][], int[][] memo) {
    if (arr[m][n] == 1)
      return 0;

    if (m == 0 && n == 0)
      return 1;
    if (memo[m][n] != -1)
      return memo[m][n];
    int left = 0, right = 0;
    if (m > 0)
      left = f(m - 1, n, arr, memo);
    if (n > 0)
      right = f(m, n - 1, arr, memo);

    memo[m][n] = left + right;
    // return left + right;//Same working
    return memo[m][n];
  }
}