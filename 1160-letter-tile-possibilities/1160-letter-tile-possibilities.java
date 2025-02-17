import java.util.*;

class Solution {
    int count = 0;

    public int numTilePossibilities(String tiles) {
        Map<Character, Integer> map = new HashMap<>();

        // Count the frequency of each character
        for (char c : tiles.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Start the backtracking process
        solve(map);
        return count;
    }

    public void solve(Map<Character, Integer> map) {
        // For each character, if its count is > 0, it can be used to form a sequence
        for (Map.Entry<Character, Integer> i : map.entrySet()) {
            // If the character count is positive
            if (i.getValue() > 0)
             {
                // Form a valid sequence by using this character
                count++; // Add this sequence

                // Reduce the frequency of this character
                map.put(i.getKey(), i.getValue() - 1);

                // Continue to form further sequences
                solve(map);

                // Backtrack, restore the frequency of the character
                map.put(i.getKey(), i.getValue() + 1);
            }
        }
    }
}
