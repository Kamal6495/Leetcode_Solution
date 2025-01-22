#include <bits/stdc++.h>
using namespace std;

void solve(int row, int col, string path, vector<vector<int>> &maze, vector<vector<int>> &vis, int n, vector<string> &ans)
{
    // Base case: Reached the destination
    if (row == n - 1 && col == n - 1) {
        ans.push_back(path);
        return;
    }

    // Mark the cell as visited
    vis[row][col] = 1;

    // Downward movement
    if (row + 1 < n && !vis[row + 1][col] && maze[row + 1][col] == 1) {
        solve(row + 1, col, path + 'D', maze, vis, n, ans);
    }

    // Left movement
    if (col - 1 >= 0 && !vis[row][col - 1] && maze[row][col - 1] == 1) {
        solve(row, col - 1, path + 'L', maze, vis, n, ans);
    }

    // Right movement
    if (col + 1 < n && !vis[row][col + 1] && maze[row][col + 1] == 1) {
        solve(row, col + 1, path + 'R', maze, vis, n, ans);
    }

    // Upward movement
    if (row - 1 >= 0 && !vis[row - 1][col] && maze[row - 1][col] == 1) {
        solve(row - 1, col, path + 'U', maze, vis, n, ans);
    }

    // Backtrack: Unmark the cell as visited
    vis[row][col] = 0;
}

vector<string> findPath(vector<vector<int>> &maze, int n)
{
    vector<string> ans;
    vector<vector<int>> vis(n, vector<int>(n, 0)); // Correct initialization
    if (maze[0][0] == 1) {
        solve(0, 0, "", maze, vis, n, ans);
    }
    return ans;
}

int main() {
    int n;
    //cout << "Enter the size of the maze (n): ";
    cin >> n;

    vector<vector<int>> maze(n, vector<int>(n));
    //cout << "Enter the maze matrix row by row:" << endl;

    // Input the maze
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> maze[i][j];
        }
    }

    // Find all paths
    vector<string> ans = findPath(maze, n);

    // Print the paths
    if (ans.empty()) {
        cout << "No path found" << endl;
    } else {
       // cout << "Paths from top-left to bottom-right:" << endl;
        for (const auto &path : ans) {
            cout << path << endl;
        }
    }

    return 0;
}
