class Solution {
  public int rob(int[] nums) {
    int memo[] = new int[nums.length];
    Arrays.fill(memo,-1);
    return CalcMoney(nums, nums.length - 1, memo);
  }

  public int CalcMoney(int[] nums, int idx, int memo[]) {
    if (idx == 0)
      return nums[idx];
    if (idx < 0)
      return 0;
    if (memo[idx] != -1)
      return memo[idx];
    int pick = nums[idx] + CalcMoney(nums, idx - 2,memo);
    int notpick = 0 + CalcMoney(nums, idx - 1,memo);
    memo[idx] = Math.max(pick, notpick);
    return memo[idx];
  }
}