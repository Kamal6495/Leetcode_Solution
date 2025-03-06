class Solution {
public:
    vector<int> findMissingAndRepeatedValues(vector<vector<int>>& arr) {

        long long Sac = 0, Sex = 0, S2ac = 0, S2ex = 0;
        long long A, B;
        int n = arr.size() * arr.size();

        Sex = n * (n + 1) / 2ll;
        S2ex = n * (n + 1ll) * (2ll * n + 1ll) / 6ll;

        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr[i].size(); j++) {
                int t = arr[i][j];
                Sac = Sac + (long long)t;
                S2ac = S2ac + ((long long)t * (long long)t);
            }
        }

        A = Sex - Sac;
        B = (S2ex - S2ac) / A;

        int X = (A + B) / 2;
        int Y = (B - A) / 2;

        return {Y, X};
    }
};