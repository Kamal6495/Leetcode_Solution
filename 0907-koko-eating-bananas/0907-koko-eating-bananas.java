class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = maxx(piles);
        int ans = high;

        while (low <= high) {
            int mid = low + ((high - low) / 2);

            long hours = sum(piles, mid); // use long to avoid overflow
            if (hours <= h) {
                ans = mid;
                high = mid - 1; // try smaller speed
            } else {
                low = mid + 1;  // need more speed
            }
        }
        return ans;
    }

    public long sum(int[] arr, int speed) {
        long total = 0;
        for (int bananas : arr) {
            total += (bananas + speed - 1) / speed; // ceil division without float
        }
        return total;
    }

    public int maxx(int[] arr) {
        int maxVal = Integer.MIN_VALUE;
        for (int num : arr) {
            maxVal = Math.max(maxVal, num);
        }
        return maxVal;
    }
}
