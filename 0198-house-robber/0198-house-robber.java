class Solution {
  public int rob(int[] nums) {
    int n = nums.length;
    int dp[] = new int[n];
    int prev2 = 0;
    int prev = nums[0];
    for (int i = 1; i < n; i++) {
      int pick = nums[i];
      if (i > 1)
        pick += prev2;
      int notpick = 0 + prev;
      int curr_i = Math.max(pick, notpick);
      prev2 = prev;
      prev = curr_i;
    }
    return prev;//dp[n - 1];
  }

}