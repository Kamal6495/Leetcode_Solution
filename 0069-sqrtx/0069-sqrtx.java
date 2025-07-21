class Solution {
    public int mySqrt(int x) {
        long low = 1;
        long high = (long) x;

        while (low <= high) {
            long mid = low + ((high - low) / 2);
            if (mid * mid <= (long) x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return (int) high;
    }
}