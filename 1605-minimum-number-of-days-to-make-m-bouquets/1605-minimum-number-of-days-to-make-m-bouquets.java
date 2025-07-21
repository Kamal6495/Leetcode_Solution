class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int minD = Integer.MAX_VALUE;
        int maxD = Integer.MIN_VALUE;

        if (m * k > bloomDay.length)
            return -1;
        for (int num : bloomDay) {
            minD = Math.min(minD, num);
            maxD = Math.max(maxD, num);
        }

        int low = minD;
        int high = maxD;
        int ans = -1;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (possible(bloomDay, m, k, mid)) {
                ans = mid;
                high = mid - 1;
            }

            else
                low = mid + 1;
        }

        return ans;
    }

    public boolean possible(int[] arr, int m, int k, int i) {
        int bouquet = 0;
        int cnt = 0;

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] <= i)
                cnt++;
            else {
                bouquet += (cnt / k);
                cnt = 0;
            }
        }
        bouquet += (cnt / k);
        if (bouquet >= m)
            return true;

        return false;
    }

}