class Solution {
  public int splitArray(int[] arr, int k) {
    // code here
    int n = arr.length;
    int low = -1;
    int high = 0;
    for (int num : arr) {
      low = Math.max(low, num);
      high += num;
    }

    while (low <= high) {
      int mid = low + ((high - low) / 2);

      int countPainter = assignPainter(arr, k, mid);
      if (countPainter <= k)
        high = mid - 1;
      else
        low = mid + 1;
    }
    return low;
  }

  public int assignPainter(int[] arr, int k, int unit) {
    int lastPainter = 0;
    int count = 1;

    for (int num : arr) {
      if (num + lastPainter <= unit)
        lastPainter += num;
        else {
          lastPainter = num;
          count++;
        }
    }
    return count;
  }
}
