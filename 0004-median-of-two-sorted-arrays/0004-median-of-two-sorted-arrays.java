class Solution {
  public double findMedianSortedArrays(int[] arr1, int[] arr2) {
    int n1 = arr1.length, n2 = arr2.length;
    if (n1 > n2)
      return findMedianSortedArrays(arr2, arr1);

    int low = 0;
    int high = n1;
    int left = ((n1 + n2 + 1) / 2);
    while (low <= high) {
      int mid1 = low + ((high - low) / 2);
      int mid2 = left - mid1;
      int l1 = (mid1 > 0) ? arr1[mid1 - 1] : Integer.MIN_VALUE;
      int l2 = (mid2 > 0) ? arr2[mid2 - 1] : Integer.MIN_VALUE;
      int r1 = (mid1 < n1) ? arr1[mid1] : Integer.MAX_VALUE;
      int r2 = (mid2 < n2) ? arr2[mid2] : Integer.MAX_VALUE;

      if (l1 <= r2 && l2 <= r1) {
        int l = Math.max(l1, l2);
        int r = Math.min(r1, r2);
        if ((n1 + n2) % 2 == 1)
          return (double) l;

        return (double) ((l + r) / 2.0);
      }
      if (l1 > r2)
        high = mid1 - 1;
      else
        low = mid1 + 1;
    }
    return 0.0;
  }
}