class Solution {
  public int minimumTotal(List<List<Integer>> triangle) {
    int m = triangle.size();
    int n = triangle.get(m - 1).size();

    int next[] = new int[n];

    for (int j = 0; j < n; j++) {
      next[j] = triangle.get(m - 1).get(j);
    }

    for (int i = m - 2; i >= 0; i--) {
      int curr[] = new int[n];

      for (int j = 0; j < triangle.get(i).size(); j++) {

        int up = triangle.get(i).get(j) + next[j];
        int upleft = triangle.get(i).get(j) + next[j + 1];

        int ans = Math.min(up, upleft);
        curr[j] = ans;
      }
      next=curr;
    }
    return next[0];
  }
}