class Solution {
  public double findMedianSortedArrays(int[] arr1, int[] arr2) {
    int n1 = arr1.length, n2 = arr2.length;
    int i = 0, j = 0, cnt = 0;
    int idx1 = (n1 + n2) / 2;
    int idx2 = ((n1 + n2) / 2) - 1;
    int ele1 = -1;
    int ele2 = -1;
    while (i < n1 && j < n2) {
      if (arr1[i] <= arr2[j]) {
        if (cnt == idx1)
          ele1 = arr1[i];
        if (cnt == idx2)
          ele2 = arr1[i];
        i++;
        cnt++;

      } else {
        if (cnt == idx1)
          ele1 = arr2[j];
        if (cnt == idx2)
          ele2 = arr2[j];
        j++;
        cnt++;
      }
    }

    while (i < n1) {
      if (cnt == idx1)
        ele1 = arr1[i];
      if (cnt == idx2)
        ele2 = arr1[i];
      i++;
      cnt++;
    }
    while (j < n2) {
      if (cnt == idx1)
        ele1 = arr2[j];
      if (cnt == idx2)
        ele2 = arr2[j];
      j++;
      cnt++;
    }

    int size = n1 + n2;
    if (size % 2 == 0) {
      return (ele1 + ele2) / 2.0;

    }
    return ele1;
  }
}