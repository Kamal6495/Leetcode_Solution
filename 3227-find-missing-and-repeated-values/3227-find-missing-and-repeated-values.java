class Solution {
    public int[] findMissingAndRepeatedValues(int[][] arr) {
        int n = arr.length;
        int N = n * n;

        // Use long to prevent integer overflow
        long expectedSum = (long) N * (N + 1) / 2;
        long expectedSquareSum = (long) N * (N + 1) * (2 * N + 1) / 6;

        long actualSum = 0, actualSquareSum = 0;
        int[] count = new int[N + 1]; // Frequency array

        int repeated = -1, missing = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = arr[i][j];
                actualSum += num;
                actualSquareSum += (long) num * num;

                count[num]++;
                if (count[num] == 2) {
                    repeated = num;
                }
            }
        }

        long diff = expectedSum - actualSum; // missing - repeated
        missing = (int) (repeated + diff);

        return new int[]{repeated, missing};
    }
}
