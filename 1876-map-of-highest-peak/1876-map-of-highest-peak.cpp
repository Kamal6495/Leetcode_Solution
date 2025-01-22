class Solution {
    /*public:
    void print2D(const vector<vector<int>>& vec) {
    for (const auto& row : vec) {
        for (const auto& elem : row) {
            cout << elem << " "; // Print each element in the row
        }
        cout << endl; // Move to the next line after each row
    }
} */
public : vector<vector<int>> highestPeak(vector<vector<int>>& isWater) {
    int r = isWater.size();
    int c = isWater[0].size();
    vector<vector<int>> res(r, vector<int>(c, -1));
    queue<pair<int, int>> q;

    int dr[] = {0, 0, -1, 1};
    int dc[] = {1, -1, 0, 0};

    for (int i = 0; i < r; i++) {

        for (int j = 0; j < c; j++) {

            if (isWater[i][j] == 1) {
                res[i][j] = 0; // water
                q.push({i, j});
            }
        }
    }

    while (!q.empty()) {
        // print2D(res);
        pair<int, int> p = q.front();
        q.pop();
        for (int k = 0; k < 4; k++) {

            int nr = p.first + dr[k];
            int nc = p.second + dc[k];

            if (nr >= 0 && nr < r && nc >= 0 && nc < c && res[nr][nc] == -1) {
                res[nr][nc] = res[p.first][p.second] + 1;
                q.push({nr, nc});
            }
        }

        cout << endl;
    }
    return res;
}
/*
        for (int i = 0; i < r; i++) {

            for (int j = 0; j < c; j++) {
                int fg = 0;
                for (int k = 0; k < 4; k++) {

                    if ((i + dr[k]) >= 0 || (i + dr[k]) < r ||
                        (j + dc[k] >= 0) || (j + dc[k] < c)) {
                        int rr = abs(res[i][j] - res[(i + dr[k])][(j +
   dc[k])]); fg++;
                    }
                }

                if (fg % 2 == 0)
                    res[i][j]++;
            }
        }


    }*/
}
;