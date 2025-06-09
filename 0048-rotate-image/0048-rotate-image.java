class Solution {
    public void rotate(int[][] mat) {
        int n = mat.length;

        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n-i-1; j++) {
                // Save top
                int temp = mat[i][j];

                // Left → Top
                mat[i][j] = mat[n - 1 - j][i];

                // Bottom → Left
                mat[n - 1 - j][i] = mat[n - 1 - i][n - 1 - j];

                // Right → Bottom
                mat[n - 1 - i][n - 1 - j] = mat[j][n - 1 - i];

                // Top (saved) → Right
                mat[j][n - 1 - i] = temp;

            }
        }

    }
}