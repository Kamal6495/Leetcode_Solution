class Solution {
public:
    bool buddyStrings(string s1, string s2) {
        if (s1.length() != s2.length())
            return false;

        if (s1 == s2) {

            vector<int> freq(26, 0);

            for (char c : s1) {
                freq[c - 'a']++;
                if (freq[c - 'a'] > 1)
                    return true;
            }

            return false;
        }

        int count = 0;
        int fc = -1, sc = -1;
        for (int i = 0; i < s1.length(); i++) {
            if (s1[i] != s2[i]) {
                count++;
                if (count > 2)
                    return false;

                if (fc == -1)
                    fc = i;
                else
                    sc = i;
            }
        }
        // System.out.println(fc + " " + sc);

        return (count == 2 && (s1[fc] == s2[sc] && s1[sc] == s2[fc]));
    }
};