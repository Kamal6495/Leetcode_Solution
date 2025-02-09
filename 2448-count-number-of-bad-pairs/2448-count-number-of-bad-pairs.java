import java.util.HashMap;
import java.util.Map;

class Solution {
    public long countBadPairs(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> mp = new HashMap<>();
        long total = (long) n * (n - 1) / 2; // Total number of pairs
        long good = 0L;

        // Count occurrences of (i - arr[i]) and count good pairs directly
        for (int i = 0; i < n; i++) {
            int key = i - arr[i];
            good += mp.getOrDefault(key, 0); 
            mp.put(key, mp.getOrDefault(key, 0) + 1);
        }

        // Bad pairs = Total pairs - Good pairs
        return total - good;
    }
}
