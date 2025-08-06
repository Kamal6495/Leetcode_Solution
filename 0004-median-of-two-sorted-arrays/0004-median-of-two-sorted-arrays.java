class Solution {
  public double findMedianSortedArrays(int[] arr1, int[] arr2) {
    int n1 = arr1.length, n2 = arr2.length;
    int i = 0, j = 0, k = 0;
    int arr[] = new int[n1+n2];
    while (i < n1 && j < n2) {
      if (arr1[i] <= arr2[j]) {
        arr[k] = arr1[i];
        i++;
        k++;
      } else {
        arr[k] = arr2[j];
        j++;
        k++;
      }
    }

    while (i < n1) {
      arr[k] = arr1[i];
      i++;
      k++;
    }
    while (j < n2) {
      arr[k] = arr2[j];
      j++;
      k++;
    }

    int size = n1 + n2;
    if (size % 2 == 0) {
      return ((arr[size / 2] + arr[size / 2 - 1]) / 2.0);

    }
    return arr[size / 2];
  }
}