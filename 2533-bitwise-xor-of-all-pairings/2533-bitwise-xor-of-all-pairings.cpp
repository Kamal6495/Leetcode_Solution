class Solution {
public:
    int xorAllNums(vector<int>& nums1, vector<int>& nums2) {

        int sum = 0;
        int n = nums1.size();
        int m = nums2.size();

        if (n % 2 == 0 && m % 2 == 0)
            return 0;

        else if (n % 2 == 0) 

            for (int i = 0; i < n; i++)
                sum ^= nums1[i];

         else if (m % 2 == 0)
            for (int i = 0; i < m; i++)
                sum ^= nums2[i];
        else {
            for (int i = 0; i < n; i++)
                sum ^= nums1[i];
            for (int i = 0; i < m; i++)
                sum ^= nums2[i];
        }

        return sum;
    }
};
/*
Intuition in 5 minutes
Code in 6 minutes
TLE in Nano-Seconds :)
*/