class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        /*     int n = nums1.size() + nums2.size();
             int i = 0, j = 0, count = 0;

             int idx2 = n / 2;
             int idx1 = idx2 - 1;

             if (nums1.size() == 0) {
                 if (nums2.size() % 2 == 1)
                     return (double)nums2[nums2.size() / 2];

                 else {
                     double x = ((nums2[nums2.size() / 2]) +
                                 (nums2[(nums2.size() / 2) - 1])) /
                                2.0;
                     return x;
                 }
             }
             if (nums2.size() == 0) {
                 if (nums1.size() % 2 == 1)
                     return (double)nums1[nums1.size() / 2];

                 else {
                     double x = ((nums1[nums1.size() / 2]) +
                                 (nums1[(nums1.size() / 2) - 1])) /
                                2.0;
                     return x;
                 }
             }
     cout<<"idx1 "<<idx1<<" idx2 "<<idx2;
             double e1 = 0, e2 = 0;
             while (i < nums1.size() && j < nums2.size()) {

                 if (nums1[i] <= nums2[j]) {
                     if (count == idx1)
                         e1 = nums1[i];
                     if (count == idx2)
                         e2 = nums1[i];
                     i++;
                     cout << e1 << " i " << e2 << "  " << count << endl;
                     count++;

                 } else {

                     if (count == idx1)
                         e1 = nums2[j];
                     if (count == idx2)
                         e2 = nums2[j];
                     j++;
                     count++;
                     cout << e1 << " j " << e2 << "  " << count << endl;
                 }
             }

             while (i < nums1.size()) {

                 if (count == idx1)
                     e1 = nums1[i];
                 if (count == idx2)
                     e2 = nums1[i];
                 i++;
                 count++;
                  cout << e1 << "  " << i << " i1 " << e2 << endl;
             }

             while (j < nums2.size()) {

                 if (count == idx1)
                     e1 = nums2[j];
                 if (count == idx2)
                     e2 = nums2[j];

                  cout << e1 << "  " << count <<"  j= "<<j<< " j1 " << e2 <<
     endl; j++; count++;

             }

             if (n % 2 == 1)
                 return e2;
             else
                 return (e1 + e2) * 0.5;*/

        int n = nums1.size();
        int m = nums2.size();
        int i = 0, j = 0, m1 = 0, m2 = 0;

        // Find median.
        for (int count = 0; count <= (n + m) / 2; count++) {
            m2 = m1;
            if (i != n && j != m) {
                if (nums1[i] > nums2[j]) {
                    m1 = nums2[j++];
                } else {
                    m1 = nums1[i++];
                }
            } else if (i < n) {
                m1 = nums1[i++];
            } else {
                m1 = nums2[j++];
            }
        }

        // Check if the sum of n and m is odd.
        if ((n + m) % 2 == 1) {
            return static_cast<double>(m1);
        } else {
            double ans = static_cast<double>(m1) + static_cast<double>(m2);
            return ans / 2.0;
        }
    }
};

/*
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        if (nums1.size() > nums2.size()) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.size();
        int n = nums2.size();
        int left = 0, right = m, halfLen = (m + n + 1) / 2;

        while (left <= right) {
            int i = (left + right) / 2;
            int j = halfLen - i;

            if (i < right && nums1[i] < nums2[j - 1]) {
                left = i + 1;
            } else if (i > left && nums1[i - 1] > nums2[j]) {
                right = i - 1;
            } else {
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = max(nums1[i - 1], nums2[j - 1]);
                }

                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = min(nums1[i], nums2[j]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }

        return 0.0;
    }
};
*/