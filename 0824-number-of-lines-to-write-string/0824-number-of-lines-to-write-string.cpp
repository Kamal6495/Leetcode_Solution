class Solution {
public:
    vector<int> numberOfLines(vector<int>& widths, string s) {
        int sum = 0, line = 1;

        for (char c : s) {
            int width = widths[c - 'a'];

            if (sum + width > 100) { // Check before adding width
                line++; 
                sum = width; // Start new line with the current character's width
            } else {
                sum += width; // Add width normally
            }
        }

        return {line, sum};
    }
};
