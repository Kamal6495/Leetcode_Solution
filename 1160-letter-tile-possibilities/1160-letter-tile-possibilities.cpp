class Solution {
public:
    int count = 0;

    void backtrack(vector<int> &freq) {
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                count++;   // Every valid choice is a new sequence
                
                freq[i]--; // Use this tile
                backtrack(freq);
                freq[i]++; // Restore for other choices
            }
        }
    }

    int numTilePossibilities(string tiles) {
        vector<int> freq(26, 0);
        
        for (char ch : tiles)
            freq[ch - 'A']++;  // Count tile frequencies
        
        backtrack(freq);
        return count;
    }
};