class Solution {
public:
    void printGrid(const vector<vector<long long>>& matrix) {
        for (const auto& row : matrix) {
            for (long long val : row) {
                cout << val << " ";
            }
            cout << endl;
        }
    }


public:
    long long gridGame(vector<vector<int>>& grid) {
long long res = LLONG_MAX; // Initialize to maximum possible value
        size_t n = grid[0].size(); // Use size_t for size

        vector<vector<long long>> presum(2, vector<long long>(n, 0)); // Use long long for prefix sums
        presum[0][0] = 0;
        presum[1][0] = grid[1][0];
        for (size_t i = 1; i < n; i++) {
            presum[0][i] = grid[0][i] + presum[0][i - 1];
            presum[1][i] = grid[1][i] + presum[1][i - 1];
        }

        presum[1][n - 1] = 0; // Logic here may need revisiting

         res = min(res, presum[0][n - 1]);

 //cout<<"RES==>"<<res;
        for (size_t i = 1; i < n; i++) {
            long long r0 = presum[0][n - 1] - presum[0][i];

            
            long long r1 = presum[1][i-1];
            cout<<"RO= "<<r0<<"R1= "<<r1<<endl;
            
            res = min(res, max(r0, r1));
        }

       // printGrid(presum);
        return res;
    }
};