class Solution {
  public int minimumTotal(List<List<Integer>> triangle) {
    int m = triangle.size();
    int n = triangle.get(m - 1).size();

    int dp[][] = new int[m][n];

    for (int j = 0; j < n; j++) {
      dp[m - 1][j] = triangle.get(m - 1).get(j);
    }

    for (int i = m - 2; i >= 0; i--) {
      for (int j =  0; j <triangle.get(i).size(); j++) {
        int up = Integer.MAX_VALUE;
        int upleft = Integer.MAX_VALUE;

        up = triangle.get(i).get(j) + dp[i + 1][j];
        upleft = triangle.get(i).get(j) + dp[i + 1][j + 1];

        int ans = Math.min(up, upleft);
        dp[i][j] = ans;
      }
    }
    return dp[0][0];
  }
}