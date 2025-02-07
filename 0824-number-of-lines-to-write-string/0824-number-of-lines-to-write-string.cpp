;
class Solution {
public:
    vector<int> numberOfLines(vector<int>& widths, string s) {

        int sum = 0, line = 1;
        for (char c : s) {
            int width = widths[c - 'a'];

            if (sum + width > 100) {
                line++;
                sum = width;
            } else {
                sum += width;
            }
        }
        return {line, sum};
    }
};