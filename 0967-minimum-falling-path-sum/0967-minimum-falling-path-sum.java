class Solution {
  public int minFallingPathSum(int[][] matrix) {

    int m = matrix.length;
    int n = matrix[0].length;
    int res = Integer.MAX_VALUE;
    int memo[][] = new int[m][n];

    for (int i = 0; i < m; i++) {
      Arrays.fill(memo[i], -1);
    }

    for (int i = 0; i < n; i++) {
      res = Math.min(res, f(0, i, matrix, memo));
    }
    return res;
  }

  public int f(int row, int col, int[][] mat, int[][] memo) {
    if (row == mat.length - 1)
      return mat[row][col];

    if (memo[row][col] != -1)
      return memo[row][col];
    int left = Integer.MAX_VALUE;
    int down = Integer.MAX_VALUE;
    int right = Integer.MAX_VALUE;
    if (col > 0)
      left = mat[row][col] + f(row + 1, col - 1, mat, memo);
    down = mat[row][col] + f(row + 1, col, mat, memo);
    if (col < mat[row].length - 1)
      right = mat[row][col] + f(row + 1, col + 1, mat, memo);

    int ans = Math.min(Math.min(left, down), right);
    memo[row][col] = ans;
    return ans;

  }
}