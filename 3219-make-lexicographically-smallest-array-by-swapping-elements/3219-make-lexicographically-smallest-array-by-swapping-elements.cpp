class Solution {
public:
    vector<int> lexicographicallySmallestArray(vector<int>& nums, int limit) {

        // step 1 finding eecah postion index
        vector<pair<int, int>> xy;

        for (int i = 0; i < nums.size(); i++)
            xy.push_back({nums[i], i});

        // step 2 make ordered group with indices  by sorting (it brings same
        // group item togehter)
        sort(xy.begin(), xy.end());

        // step 2 order the inces(two poineter+sorting+placing values)

        int left = 0, right = 1;
        int n = nums.size();
        while (right < n) {
            vector<int> pos = {xy[left].second};

            while (right < n &&
                   abs(xy[right].first - xy[right-1].first) <= limit) {
                pos.push_back(xy[right].second);
                right++;
            }

            sort(pos.begin(), pos.end());

            // placing ordered values
            for (int i = 0; i < right - left; i++)
                nums[pos[i]] = xy[left + i].first;

            left = right;
            right++;
        }

        return nums;
    }
};