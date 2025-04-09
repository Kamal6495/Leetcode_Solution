class Solution {
public:
    int minOperations(vector<int>& nums, int k) {
        
        unordered_set<int> s;
        for(int i=0;i<nums.size();i++){
            if(nums[i]<k)
            return -1;
            if(nums[i]>k)
            s.insert(nums[i]);
        }
        return s.size();

    }
};