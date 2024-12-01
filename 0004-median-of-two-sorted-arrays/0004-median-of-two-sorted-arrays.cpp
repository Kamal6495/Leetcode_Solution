class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int n = nums1.size() + nums2.size();
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
           
             cout << e1 << "  " << count <<"  j= "<<j<< " j1 " << e2 << endl;
            j++;
            count++;
           
        }

        if (n % 2 == 1)
            return e2;
        else
            return (e1 + e2) * 0.5;
    }
};