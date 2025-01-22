/*
Backtracking Approach:

Define the Solution: Each queen must be placed in a row and a column where it doesn’t conflict with others.
Constraints:
No two queens in the same row.
No two queens in the same column.
No two queens on the same diagonal.
*/


#include <bits/stdc++.h>
using namespace std;

void printBoard(vector<vector<string>> &x)
{
    for (auto &solution : x)
    {
        for (auto &row : solution)
        {
            cout << row << endl; // Print each row of the solution
        }
        cout << endl; // Separate solutions with an empty line
    }
}

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

int main()
{
    int n = 4;
    cin >> n;
    vector<vector<string>> solutions = solveNQueens(n);
    if (solutions.empty())
    {
        cout << "No Solution" << endl;
        return 0;
    }
    cout << "Number of Solutions= "<<solutions.size()<<"\n"<< endl;
    printBoard(solutions);
}
