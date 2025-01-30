class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.'); // Fill each row with '.'
        }

        solve(ans, board, 0, n);

        return ans;

    }

    public void solve(List<List<String>> ans, char[][] board, int col, int n) {

        if (col == n) {
            List<String> temp = new ArrayList<>();
            for (char[] row : board) {
                temp.add(new String(row)); // Convert char[] to String
            }
            ans.add(temp);
            return;
        }

        for (int row = 0; row < n; row++) {

            if (isSafe(row, col, board)) {
                board[row][col] = 'Q';
                solve(ans, board, col + 1, n);
                board[row][col] = '.';

            }
        }

    }

    public boolean isSafe(int row, int col, char[][] board) {
        int rr = row;
        int cc = col;
        // left row
        while (cc>= 0) {
            if (board[rr][cc] == 'Q')
                return false;
            cc--;
        }
        rr = row;
        cc = col;
        while (rr >= 0 && cc >= 0) {
            if (board[rr][cc] == 'Q')
                return false;
            rr--;
            cc--;
        }
        rr = row;
        cc = col;
        while (rr < board.length && cc >= 0) {
            if (board[rr][cc] == 'Q')
                return false;
            rr++;
            cc--;
        }
        return true;
    }
}