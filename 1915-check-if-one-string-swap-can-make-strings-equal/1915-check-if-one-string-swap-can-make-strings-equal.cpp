class Solution {
public:
    bool areAlmostEqual(string s1, string s2) {
        if (s1 == s2)
            return true;

        int fc = -1, sc = -1;
        int c = 0;
        for (int i = 0; i < s2.length(); i++) {

            if (s1[i] != s2[i]) {
                if (c > 2)
                    return false;

                if (fc == -1)
                    fc = i;
                else
                    sc = i;

                c++;
            }
        }
        if (c == 2 && s1[fc] == s2[sc] && s2[fc] == s1[sc])
            return true;

        return false;
    }
};