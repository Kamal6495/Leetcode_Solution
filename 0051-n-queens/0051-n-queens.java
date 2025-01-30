class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.'); // Fill each row with '.'
        }

        int lr[] = new int[n];
        int ld[] = new int[2 * n - 1];
        int ud[] = new int[2 * n - 1];

        Arrays.fill(lr, 0);
        Arrays.fill(ld, 0);
        Arrays.fill(ud, 0);

        solve(ans, board, 0, n,lr,ld,ud);

        return ans;

    }

    // lr=leftroe,ld=lowerdiagonal,ud=upperdiagonal
    public void solve(List<List<String>> ans, char[][] board, int col, int n, int lr[], int ld[], int ud[]) {

        if (col == n) {
            List<String> temp = new ArrayList<>();
            for (char[] row : board) {
                temp.add(new String(row)); // Convert char[] to String
            }
            ans.add(temp);
            return;
        }

        for (int row = 0; row < n; row++) {

            if (lr[row] == 0 && ld[row + col] == 0 && ud[n - 1 - (row - col)] == 0) {
                board[row][col] = 'Q';
                lr[row] = 1;
                ld[row + col] = 1;
                ud[n - 1 - (row - col)] = 1;

                solve(ans, board, col + 1, n, lr, ld, ud);

                board[row][col] = '.';
                lr[row] = 0;
                ld[row + col] = 0;
                ud[n - 1 - (row - col)] = 0;

            }
            /*
             * if (isSafe(row, col, board)) {
             * board[row][col] = 'Q';
             * solve(ans, board, col + 1, n);
             * board[row][col] = '.';
             * 
             * }
             */
        }

    }

    /*
     * public boolean isSafe(int row, int col, char[][] board) {
     * int rr = row;
     * int cc = col;
     * // left row
     * while (cc>= 0) {
     * if (board[rr][cc] == 'Q')
     * return false;
     * cc--;
     * }
     * rr = row;
     * cc = col;
     * while (rr >= 0 && cc >= 0) {
     * if (board[rr][cc] == 'Q')
     * return false;
     * rr--;
     * cc--;
     * }
     * rr = row;
     * cc = col;
     * while (rr < board.length && cc >= 0) {
     * if (board[rr][cc] == 'Q')
     * return false;
     * rr++;
     * cc--;
     * }
     * return true;
     * }
     */
}