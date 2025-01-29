class Solution {

public:
    void auxPermute(int ind, int n, vector<int>& nums, vector<vector<int>>& ans,
                    map<int, int>& mp, vector<int>& ds) {

        if (ds.size() == n) {
            ans.push_back(ds);
            return;
        }

        for (int i = ind; i < n; i++) {

            if (!mp[i]) {

                mp[i] = 1;
                ds.push_back(nums[i]);
                auxPermute(ind, n, nums, ans, mp, ds);
                ds.pop_back();
                mp[i] = 0;
            }
        }
    }

public:
    vector<vector<int>> permute(vector<int>& nums) {

        vector<vector<int>> ans;
        vector<int> ds;
        map<int, int> mp;

        auxPermute(0, nums.size(), nums, ans, mp, ds);
        return ans;
    }
};