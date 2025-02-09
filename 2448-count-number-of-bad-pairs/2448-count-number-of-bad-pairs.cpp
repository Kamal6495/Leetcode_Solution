class Solution {
public:
    long long countBadPairs(vector<int>& arr) {
        int n = arr.size();
        long long total = (long long)n * (n - 1) / 2;
        long long good=0l;
        unordered_map<int, int> mp;

        for (int i = 0; i < n; i++) {
            int key = i - arr[i];
            if (mp.find(key)!=mp.end())
                good += mp[key];
            mp[key]++;
        }

        return total - good;
    }
};