class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2))
            return true;

        int fc = -1, sc = -1;
        int count = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (count > 2)
                    return false;

                if (fc == -1)
                    fc = i;
                else
                    sc = i;
            }
        }
        if (count == 2 && s1.charAt(fc) == s2.charAt(sc) && s1.charAt(sc) == s2.charAt(fc))
            return true;


            return false;
    }
}
