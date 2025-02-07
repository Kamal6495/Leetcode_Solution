class Solution {
public:
    vector<int> queryResults(int l, vector<vector<int>>& arr) {
        int n = arr.size();
        vector<int> res(n, 0);
        map<int, int> mp;
        map<int, int> clr;

        for (int i = 0; i < n; i++) {

            int ball = arr[i][0];
            int color = arr[i][1];

            if (mp.count(ball)) {
                // reduc frequency of color of the ball to be re-painted
                clr[mp[ball]]--;
                if (clr[mp[ball]] == 0)
                    clr.erase(mp[ball]);
            }
            mp[ball] = color;
            clr[color]++;

            res[i] = (clr.size());
        }

        return res;
    }
};