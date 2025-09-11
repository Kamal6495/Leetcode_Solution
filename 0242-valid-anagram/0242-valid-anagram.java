class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        // ASCII charset is enough (0-127)
        int[] freq = new int[128];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
            freq[t.charAt(i)]--;
        }

        // Check if all counts are zero
        for (int count : freq) {
            if (count != 0) return false;
        }

        return true;
    }
}
