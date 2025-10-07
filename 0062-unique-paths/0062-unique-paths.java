class Solution {
  public int uniquePaths(int m, int n) {
    int prev[] = new int[n];
    Arrays.fill(prev,1);

    //Iterative Reverse
    for (int i = 1; i < m; i++) {
      int curr[] = new int[n];
      curr[0] = 1;
      for (int j = 1; j < n; j++) {
        int left = 0, right = 0;
        if (i > 0)
          left = prev[j];
        if (j > 0)
          right = curr[j - 1];

        curr[j] = left + right;

      }
      prev = curr;
    }
    return prev[n - 1];
  }

}