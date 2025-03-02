class Solution {
public:
    vector<vector<int>> mergeArrays(vector<vector<int>>& nums1, vector<vector<int>>& nums2) {
        int n = nums1.size();
        int m = nums2.size();
        vector<vector<int>> res;
        int i = 0, j = 0;

        while (i < n && j < m) {
            if (nums1[i][0] < nums2[j][0]) {
                res.push_back(nums1[i]);
                i++;
            } else if (nums1[i][0] > nums2[j][0]) {
                res.push_back(nums2[j]);
                j++;
            } else {
                res.push_back({nums1[i][0], nums1[i][1] + nums2[j][1]});
                i++;
                j++;
            }
        }

        // Add remaining elements from nums1
        while (i < n) {
            res.push_back(nums1[i]);
            i++;
        }

        // Add remaining elements from nums2
        while (j < m) {
            res.push_back(nums2[j]);
            j++;
        }

        return res;
    }
};
