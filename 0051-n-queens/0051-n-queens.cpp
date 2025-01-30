class Solution {
public:
bool isSafe(int row, int col, vector<string> &board, int n)
{
    int rr = row;
    int cc = col;

    while (rr >= 0 && cc >= 0) // left upper diagossnal cheking
    {
        if (board[rr][cc] == 'Q')
            return false;
        rr--;
        cc--;
    }

    rr = row;
    cc = col;

    while (cc >= 0) // left row cheking
    {
        if (board[rr][cc] == 'Q')
            return false;
        cc--;
    }

    rr = row;
    cc = col;

    while (rr < n && cc >= 0) // left lower diagonal cheking
    {
        if (board[rr][cc] == 'Q')
            return false;
        cc--;
        rr++;
    }

    return true;
}
void solve(int col, vector<string> &board, vector<vector<string>> &ans, int n)
{

    if (col == n)
    {
        ans.push_back(board);
        return;
    }

    for (int row = 0; row < n; row++)
    {
        if (isSafe(row, col, board, n))
        {
            board[row][col] = 'Q';
            solve(col + 1, board, ans, n);
            board[row][col] = '.';
        }
    }
}

vector<vector<string>> solveNQueens(int n)
{

    vector<vector<string>> ans;
    string s(n, '.');
    vector<string> board(n, s);

    solve(0, board, ans, n);

    return ans;
}
};