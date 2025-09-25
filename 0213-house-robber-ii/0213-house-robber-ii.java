class Solution {
  public int rob(int[] nums) {
    int n = nums.length;
    if (n == 1)
      return nums[0];
    int excludeFirst = calcMoney(nums, 1, n);

    int excludeLast = calcMoney(nums, 0, n - 1);
    return Math.max(excludeFirst, excludeLast);
  }

  int calcMoney(int nums[], int start, int end) {
    int prev2 = 0;
    int prev = nums[start];
    for (int i = start+1; i < end; i++) {
      int pick = nums[i];
      if (i > start+1)
        pick += prev2;
      int notpick = 0 + prev;
      int curr_i = Math.max(pick, notpick);
      prev2 = prev;
      prev = curr_i;
    }
    return prev;
  }
}