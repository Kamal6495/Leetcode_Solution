class Solution {
public:
    void subsetSolve(int ind, int n, vector<vector<int>>& ans,
                     vector<int>& nums, vector<int>& ds) {

     
        ans.push_back(ds);

        for (int i = ind; i < n; i++) {

            ds.push_back(nums[i]);
            subsetSolve(i + 1, n, ans, nums, ds);
            ds.pop_back();
        }
    }
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> ans;
        vector<int> ds;
        subsetSolve(0, nums.size(), ans, nums, ds);
        // sort(ans.begin(),ans.end());//lexographical sort
        return ans;
    }
};