class Solution {
public:
    int firstCompleteIndex(vector<int>& arr, vector<vector<int>>& mat) {

        int res = 0;
        int mn = arr.size();

        int m = mat.size();
        int n = mat[0].size();
        map<int, pair<int, int>> mp;
        vector<vector<int>> paint(m, vector<int>(n, 0));
        for (int rr = 0; rr < m; rr++) {
            for (int cc = 0; cc < n; cc++) {
                mp[mat[rr][cc]] = {rr, cc};
            }
        }

        vector<int> col(n,0);
        vector<int> row(m,0);

        for (int i = 0; i < mn; i++) {

            pair<int, int> point = mp[arr[i]];
            paint[point.first][point.second] = true;
            int cc = 0, rr = 0, count = 0;

            if(++col[point.second]==m)
            return i;
            if(++row[point.first]==n)
            return i;

            /*while (rr < m) {
                if (paint[rr][point.second] == 1)
                    count++;
                rr++;
            }
             if (count == m)
                return i;
            count = 0;
            while (cc < n) {
                if (paint[point.first][cc] == 1)
                    count++;

                cc++;
            }
            if (count == n)
                return i;*/


        
        }

        return res;
    }
};