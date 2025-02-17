class Solution {
public:
    void backtrack(vector<int> &freq, int &count) {
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                count++;   // Increment count when we use a tile
                
                freq[i]--; // Use this tile
                backtrack(freq, count);
                freq[i]++; // Restore the tile (backtracking)
            }
        }
    }

    int numTilePossibilities(string tiles) {
        vector<int> freq(26, 0);
        int count = 0;

        for (char ch : tiles)
            freq[ch - 'A']++;  // Count tile frequencies
        
        backtrack(freq, count);
        return count;
    }
};