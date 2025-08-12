class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    int n = matrix.length;

    for (int i = 0; i < n; i++) {
      int low = 0;
      int high = matrix[0].length-1;

      while (low <= high) {
        int mid = (low + high) >> 1;
        if (matrix[i][mid] == target)
          return true;
        else if (matrix[i][mid] > target)
          high = mid - 1;
        else
          low = mid + 1;

      }
    }
    return false;
  }
}