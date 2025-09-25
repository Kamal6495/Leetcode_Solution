class Solution {
  public int rob(int[] nums) {
    int n = nums.length;
    if (n == 1)
      return nums[0];
    int memo[] = new int[n];
    Arrays.fill(memo, -1);
    int excludeFirst = CalcMoney(nums, 0, n - 2, memo);
    Arrays.fill(memo, -1);
    int excludeLast = CalcMoney(nums, 1, n - 1, memo);
    return Math.max(excludeFirst, excludeLast);
  }

  public int CalcMoney(int[] nums, int start, int idx, int memo[]) {

    if (idx == start)
      return nums[start];
    if (idx < start)
      return 0;

    if (memo[idx] != -1)
      return memo[idx];
    int pick = nums[idx] + CalcMoney(nums, start, idx - 2,memo);
    int notpick = 0 + CalcMoney(nums, start, idx - 1,memo);

    memo[idx] = Math.max(pick, notpick);
    return memo[idx];
  }
}