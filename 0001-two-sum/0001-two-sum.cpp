class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        map<int,int> mp;

        for(int i=0;i<nums.size();i++){

            int fin=target-nums[i];

            if(mp.find(fin)!=mp.end())
            return {mp[fin],i};

            mp[nums[i]]=i;
        }

        vector<int> res;
 
return {};

    }
};