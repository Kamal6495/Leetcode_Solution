class Solution {
    public boolean rotateString(String s, String goal) {
        // lengths must match
        if (s.length() != goal.length()) return false;
        // KMP search for goal inside s+s
        return KMP(goal, s + s);
    }

    // Build LPS array for pattern
    public int[] LPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        char[] P = pattern.toCharArray();

        int len = 0; // length of previous longest prefix suffix
        lps[0] = 0;  // first char always 0

        for (int i = 1; i < m; i++) {
            while (len > 0 && P[i] != P[len]) {
                len = lps[len - 1]; // fallback
            }
            if (P[i] == P[len]) {
                len++;
            }
            lps[i] = len;
        }
        return lps;
    }

    // KMP Search
    public boolean KMP(String pattern, String text) {
        char[] P = pattern.toCharArray();
        char[] T = text.toCharArray();

        int[] LPS = LPS(pattern);
        int len = 0; // matched chars so far

        for (int i = 0; i < T.length; i++) {
            // Fallback while mismatch
            while (len > 0 && T[i] != P[len]) {
                len = LPS[len - 1];
            }
            // Match case
            if (T[i] == P[len]) {
                len++;
            }
            // Full match found
            if (len == P.length) {
                System.out.printf("✔ Pattern found at index: %d%n", (i - len + 1));
                return true; // found
            }
        }
        return false; // not found
    }
}
