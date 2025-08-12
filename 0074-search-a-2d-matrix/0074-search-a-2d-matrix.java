class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    int rowsize = matrix.length;
    int colsize = matrix[0].length;

    int low = 0;
    int high = (rowsize * colsize) - 1;

    while (low <= high) {
      int mid = (low + high) >> 1;

      int rowN = mid / colsize;
      int colN = mid % colsize;

      if (matrix[rowN][colN] == target)
        return true;
      else if (matrix[rowN][colN] > target)
        high = mid - 1;
      else
        low = mid + 1;

    }
    return false;
  }
}