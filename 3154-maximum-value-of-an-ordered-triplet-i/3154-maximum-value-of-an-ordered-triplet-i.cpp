class Solution {
    #define ll long long
public:
    long long maximumTripletValue(vector<int>& nums) {
        int n=nums.size();
        ll max_diff = 0;
        ll max_left = 0;
        ll max_triplet = 0;
        for(int i=0;i<n;++i){
            max_triplet = max<ll>(max_triplet,1LL*max_diff*nums[i]);
            max_diff = max<ll>(max_diff,(max_left-nums[i]));
            max_left = max<ll>(max_left,nums[i]);
        }
        return max_triplet;
    }
};