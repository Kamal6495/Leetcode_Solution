class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    int n = matrix.length;
    int m = matrix[0].length;

    int row = 0;
    int col = m - 1;

    while (row < n && col >= 0) {
      int curr = matrix[row][col];  // moved inside

      if (curr == target)
        return true;
      else if (curr < target)
        row++;
      else
        col--;
    }

    return false;
  }
}
