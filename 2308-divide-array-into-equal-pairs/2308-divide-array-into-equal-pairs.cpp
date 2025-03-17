class Solution {
public:
    bool divideArray(vector<int>& nums) {
        map<int, int> res;

        for (int i = 0; i < nums.size(); i++) {

            res[nums[i]]++;
        }

        for (auto i : res) {
            if (i.second % 2 != 0)
                return false;
        }
        return true;
    }
};