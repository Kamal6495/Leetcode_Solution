class Solution {
    public long coloredCells(int n) {
        long res = 1l;

        for (int i = 1; i < n; i++) {
            res += 4l * (long) i;

        }

        return res;
    }
}