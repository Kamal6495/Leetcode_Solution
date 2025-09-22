class Solution {
  public int climbStairs(int n) {
    if (n <= 1) return 1;

    int prevPrev = 1;  // ways to climb 0 steps
    int prev = 1;      // ways to climb 1 step
    int curr = 0;

    for (int i = 2; i <= n; i++) {
      curr = prevPrev + prev;
      prevPrev = prev;
      prev = curr;
    }
    return curr;
  }
}
