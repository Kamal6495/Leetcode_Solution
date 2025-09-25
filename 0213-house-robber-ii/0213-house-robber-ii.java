class Solution {
  public int rob(int[] nums) {
    int n = nums.length;
    if (n == 1)
      return nums[0];

    int prev2 = 0;
    int prev = nums[1];
    // int dp[] = new int[n];
    // dp[1] = nums[1];
    for (int i = 2; i < n; i++) {
      int pick = nums[i];
      if (i > 1)
        pick += prev2;
      int notpick = 0 + prev;
      int curr_i = Math.max(pick, notpick);
      prev2 = prev;
      prev = curr_i;
    }
    int excludeFirst = prev;

    prev2 = 0;
    prev = nums[0];
    for (int i = 1; i < n - 1; i++) {
      int pick = nums[i];
      if (i > 1)
        pick += prev2;
      int notpick = 0 + prev;
      int curr_i = Math.max(pick, notpick);
      prev2 = prev;
      prev = curr_i;
    }
    int excludeLast = prev;
    return Math.max(excludeFirst, excludeLast);
  }
}