class Solution {
    public int lastNegative(int[] arr, int n) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < 0) {
                if (mid == n - 1 || arr[mid + 1] >= 0) 
                    return mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public int firstPositive(int[] arr, int n) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > 0) {
                if (mid == 0 || arr[mid - 1] <= 0)  // Fixed condition
                    return mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int maximumCount(int[] arr) {
        int n = arr.length;
        int x = lastNegative(arr, n);
        int y = firstPositive(arr, n);

        int neg = x + 1;  // Count of negative numbers
        int pos = (y == -1) ? 0 : n - y;  // Count of positive numbers

        return Math.max(pos, neg);
    }

};
