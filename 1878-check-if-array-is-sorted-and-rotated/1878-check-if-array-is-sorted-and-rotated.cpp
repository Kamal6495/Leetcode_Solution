class Solution {
public:
    bool check(vector<int>& arr) {
        
         int count = 0, ind = -1;
        int n = arr.size();
        for (int i = 1; i < n; i++) {
            if (count < 2) {
                if (arr[i] < arr[i - 1])
                    count++;
                ind = i;

            }

        }

        return count > 1 ? false : (count == 0 ? true : (arr[0] >= arr[ind] && arr[0] >= arr[n - 1]));
    }
};