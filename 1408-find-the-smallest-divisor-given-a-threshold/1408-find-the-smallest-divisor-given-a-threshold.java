class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int ans = -1;
        int maxN = maxA(nums);
        int low = 1;
        int high = maxN;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            int sum = 0;
            int j = 0;
            while (j < nums.length) {
                sum += ((nums[j++] + mid - 1) / mid);
            }
            if (sum <= threshold) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public int maxA(int arr[]) {
        int res = Integer.MIN_VALUE;
        for (int num : arr)
            res = Math.max(res, num);
        return res;
    }

    public int minA(int arr[]) {
        int res = Integer.MIN_VALUE;
        for (int num : arr)
            res = Math.min(res, num);
        return res;
    }
}