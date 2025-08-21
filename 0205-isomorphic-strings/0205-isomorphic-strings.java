class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] smp = new int[256]; // mapping s -> t
        int[] tmp = new int[256]; // mapping t -> s

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            // if not mapped yet
            if (smp[sc] == 0 && tmp[tc] == 0) {
                smp[sc] = tc;
                tmp[tc] = sc;
            } 
            // already mapped, must match
            else if (smp[sc] != tc || tmp[tc] != sc) {
                return false;
            }
        }
        return true;
    }
}
