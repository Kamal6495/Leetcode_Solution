class Solution {
    public int mySqrt(int x) {
        long ans = 0l;

        for (long i = 1l; i <= (long)x; i++) {
            if (i * i <= (long)x)
                ans = i;
            else
                break;
        }
        return (int)ans;
    }
}