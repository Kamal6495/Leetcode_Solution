class Solution {
  public int[] findPeakGrid(int[][] arr) {
    int rowsize = arr.length;
    int columnsize = arr[0].length;

    int low = 0;
    int high = columnsize - 1;

    while (low <= high) {
      int mid = (low + high) >> 1;
      int max_row = 0;
      for (int row = 0; row < rowsize; row++) {
        if (arr[row][mid] > arr[max_row][mid])
          max_row = row;
      }

      int leftNeighbor = (mid - 1 >= 0) ? arr[max_row][mid - 1] : -1;
      int rightNeighbor = (mid + 1 < columnsize) ? arr[max_row][mid + 1] : -1;

      if (leftNeighbor < arr[max_row][mid] && rightNeighbor < arr[max_row][mid])
        return new int[] { max_row, mid };

      else if (leftNeighbor < arr[max_row][mid])
        low = mid + 1;
      else
        high = mid - 1;

    }

    return new int[] { -1, -1 };
  }

}