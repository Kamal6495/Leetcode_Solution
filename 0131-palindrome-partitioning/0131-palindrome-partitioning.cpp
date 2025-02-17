class Solution {
public:
    bool isPalindrome(string& s, int l, int r) {

        while (l <= r) {
            if (s[l] != s[r])
                return false;
            l++;
            r--;
        }
        return true;
    }

    void solve(int ind, int n, vector<vector<string>>& res, vector<string>& ds,
               string s) {

        if (ind == n) {
            res.push_back(ds);
            return;
        }

        for (int i = ind; i < n; i++) {

            if (isPalindrome(s, ind, i)) {
                ds.push_back(s.substr(ind, i - ind + 1));
                solve(i + 1, n, res, ds, s);
                //ds.erase(ds.begin() + (ds.size() - 1));
                ds.pop_back();
            }
        }
    }

    vector<vector<string>> partition(string s) {
        vector<vector<string>> res;
        vector<string> ds;
        int n = s.length();
        solve(0, n, res, ds, s);
        return res;
    }
};