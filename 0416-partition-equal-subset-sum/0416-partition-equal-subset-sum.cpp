class Solution {
public:
    bool subsetSum(vector<int>& nums, int S) {
        int n = nums.size();
        vector<vector<bool>> t(n+1, vector<bool>(S+1, false));
        
        //It's not possible to get any sum when we have no elements
        for(int col = 0; col<S+1; col++) {
            t[0][col] = false;
        }
        
        //It's always possible to get sum=0
        for(int row = 0; row<n+1; row++) {
            t[row][0] = true;
        }
        
        
        for(int i = 1; i<n+1; i++) {
            for(int j = 1; j<S+1; j++) {
                if(nums[i-1] <= j) {
                    t[i][j] = t[i-1][j-nums[i-1]] || t[i-1][j]; //including || excluding
                } else {
                    t[i][j] = t[i-1][j]; //exluding because we can't pick element which is greater than target sum
                }
            }
        }
        
        return t[n][S];
    }
    bool canPartition(vector<int>& nums) {
        int sum = 0;
        for(int x:nums){
            sum += x;
        }
        
        if(sum%2 != 0)
            return false;
        
        sum = sum/2;
        
        return subsetSum(nums, sum);
    }
};