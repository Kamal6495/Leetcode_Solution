class Solution {
public:
    int minimumRecolors(string blocks, int k) {
        int i = 0, j = 0;
        int res = INT_MAX;
        int c = 0;

        while (j < k) {
            if (blocks[j] == 'W')
                c++;
            j++;
        }

        i++;
        res = min(res, c);
        while (i < blocks.length() && j < blocks.length()) {
            if (blocks[i - 1] == 'W')
                c--;
            if (blocks[j] == 'W')
                c++;

            res = min(res, c);

            i++;
            j++;
        }
        return res;
    }
};