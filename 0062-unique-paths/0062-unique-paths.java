class Solution {
  public int uniquePaths(int m, int n) {
	int memo[][]=new int[m][n] ;
  for(int i=0;i<m;i++)
  Arrays.fill(memo[i],-1);
		return paths(m - 1, n - 1,memo);
	}

  public int paths(int m, int n, int memo[][]) {
    if (m == 0 && n == 0) {
      return 1;
    }
    // If already computed, return stored value
    if (memo[m][n] != -1)
      return memo[m][n];
    int left = 0, right = 0;
    if (m > 0)
      left = paths(m - 1, n,memo);
    if (n > 0)
      right = paths(m, n - 1,memo);
    // System.out.printf("m=%d , n=%d l=%d r=%d\n",m,n,left,right);
    // Store result before returning
    memo[m][n] = left + right;
    return left + right;
  }
}