class Solution {
public:
    void solveSudoku(vector<vector<char>>& board) { solver(board); }
    bool isValid(vector<vector<char>>& board, char c, int row, int col) {

        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c)
                return false;
            if (board[i][col] == c)
                return false;

            if (board[(3 * (row / 3) + (i / 3))][(3 * (col / 3) + (i % 3))] ==
                c)
                return false; // col by col changing in 3X3 group
        }

        return true;
    }

    bool solver(vector<vector<char>>& board) {

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {

                if (board[r][c] == '.') {

                    for (char i = '1'; i <= '9'; i++) {

                        if (isValid(board, i, r, c)) {
                            board[r][c] = i;
                            if (solver(board) == true)
                                return true;
                            else
                                board[r][c] = '.';
                        }
                    }

                    return false;
                }
            }
        }
        return true;
    }
};