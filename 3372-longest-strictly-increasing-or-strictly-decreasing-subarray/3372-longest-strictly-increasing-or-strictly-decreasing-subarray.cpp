class Solution {
public:
    int longestMonotonicSubarray(vector<int>& arr) {
        if (arr.empty()) return 0;

        int countI = 1, countD = 1;
        int ans = 1;
        for (int j = 1; j < arr.size(); j++) {
            if (arr[j] > arr[j - 1]) {
                countI++;
                countD = 1; 
            } 
            else if (arr[j] < arr[j - 1]) {
                countD++;
                countI = 1; 
            } 
            else {
                countI = countD = 1;
            }

            ans = max(ans, max(countI, countD));
        }

        return ans;
    }
};
