// Trapping Water
#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int trapRainWater(vector<vector<int>> &grid)
    {
        int R = grid.size();
        int C = grid[0].size();
        vector<vector<int>> vis(R, vector<int>(C, 0));
        priority_queue<pair<int, pair<int, int>>, vector<pair<int, pair<int, int>>>, greater<pair<int, pair<int, int>>>> pq;
        int vol = 0;
        for (int i = 0; i < R; i++)
        {

            for (int j = 0; j < C; j++)
            {

                if (i == 0 || i == R - 1 || j == 0 || j == C - 1)
                {
                    pq.push({grid[i][j], {i, j}});
                    vis[i][j] = true;
                }
            }
        }

        int minBdHt = 0;

        while (!pq.empty())
        {
            int currBdHt = pq.top().first;
            int x = pq.top().second.first;
            int y = pq.top().second.second;
            minBdHt = max(currBdHt, minBdHt);
            pq.pop();
            int dr[] = {0, 0, -1, 1}; // Stay in the same row for right/left, or move up/down.
            int dc[] = {1, -1, 0, 0}; // Stay in the same column for up/down, or move right/left.

            for (int i = 0; i < 4; i++)
            {
                int rr = x + dr[i];
                int cc = y + dc[i];
                if (rr >= 0 && rr < R && cc >= 0 && cc < C && vis[rr][cc] == false)
                {
                    pq.push({grid[rr][cc], {rr, cc}});
                    vis[rr][cc] = true;
                    if (grid[rr][cc] < minBdHt)
                    {
                        vol += minBdHt - grid[rr][cc];
                    }
                }
            }
        }
        return vol;
    }

    int main()
    {

        int m, n;
        cin >> m >> n;
        vector<vector<int>> grid(m, vector<int>(n, 0));
        for (auto i : grid)
        {
            for (auto j : i)
                cin >> j;
        }

        cout << trapRainWater(grid);
    }
};