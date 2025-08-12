class Solution {
  public int[] findPeakGrid(int[][] arr) {
    int row = arr.length;
    int column = arr[0].length;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < column; j++) {
        // checking with top element
        if (i > 0)
          if (arr[i][j] < arr[i - 1][j])
            continue;
        // checking with right element
        if (j < column - 1)
          if (arr[i][j] < arr[i][j + 1])
            continue;
        // checking with bottom element
        if (i < row - 1)
          if (arr[i][j] < arr[i + 1][j])
            continue;
        // checking with left element
        if (j > 0)
          if (arr[i][j] < arr[i][j - 1])
            continue;

        return new int[] { i, j };
      }
    }
    return new int[] { -1, -1 };
  }

}