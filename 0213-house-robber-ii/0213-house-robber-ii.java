class Solution {
  public int rob(int[] nums) {
    int n = nums.length;
    if (n == 1)
      return nums[0];
    int dp[] = new int[n];
    dp[1] = nums[1];
    for (int i = 2; i < n; i++) {
      int pick = nums[i];
      if (i > 1)
        pick += dp[i - 2];
      int notpick = 0 + dp[i - 1];
      dp[i] = Math.max(pick, notpick);

    }

    int excludeFirst = dp[n - 1];
    Arrays.fill(dp, 0);
    dp[0] = nums[0];
    for (int i = 1; i < n - 1; i++) {
      int pick = nums[i];
      if (i > 1)
        pick += dp[i - 2];
      int notpick = 0 + dp[i - 1];
      dp[i] = Math.max(pick, notpick);

    }
    int excludeLast = dp[n - 2];
    return Math.max(excludeFirst, excludeLast);
  }
}