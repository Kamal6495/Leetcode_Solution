class Solution {
  public int minPathSum(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int memo[][] = new int[m][n];
    for (int i = 0; i < m; i++)
      Arrays.fill(memo[i], -1);
    return f(m - 1, n - 1, grid, memo);
  }

  public int f(int m, int n, int grid[][], int memo[][]) {

    if (m == 0 && n == 0)
      return grid[m][n];
    if (memo[m][n] != -1)
      return memo[m][n];
    int left = Integer.MAX_VALUE;
    int top = Integer.MAX_VALUE;
    if (m > 0)
      top = grid[m][n] + f(m - 1, n, grid, memo);
    if (n > 0)
      left = grid[m][n] + f(m, n - 1, grid, memo);

    memo[m][n] = Math.min(left, top);
    return memo[m][n];

  }
}