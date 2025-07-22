class Solution {
  public int shipWithinDays(int[] weights, int days) {
    int low = minA(weights);
    int high = sumA(weights);
    int ans = high;

    while (low <= high) {
      int mid = low + ((high - low) / 2);

      int reqiuredDays = reqDays(weights, mid);

      if (reqiuredDays <= days) { 
        ans = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return ans;
  }

  public int reqDays(int arr[], int cap) {
    int days = 1;
    int load = 0;

    for (int i = 0; i < arr.length; i++) {
      if ((arr[i] + load) > cap) {
        days = days + 1;
        load = arr[i];
      } else {
        load += arr[i];
      }
    }

    return days;
  }

  public int minA(int[] arr) {
    int x = Integer.MIN_VALUE;
    for (int num : arr)
      x = Math.max(x, num);
    return x;
  }

  public int sumA(int[] arr) {
    int x = 0;
    for (int num : arr)
      x += num;
    return x;
  }

}
