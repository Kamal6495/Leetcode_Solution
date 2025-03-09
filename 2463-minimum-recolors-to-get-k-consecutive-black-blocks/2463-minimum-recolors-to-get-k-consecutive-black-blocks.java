class Solution {
    public int minimumRecolors(String blocks, int k) {
        int i = 0, j = 0;
        int res = Integer.MAX_VALUE;
        int c = 0;

        while (j < k) {
            if (blocks.charAt(j) == 'W')
                c++;
            j++;
        }

        res = Math.min(res, c);

        while (j < blocks.length()) {
            if (blocks.charAt(i) == 'W')
                c--;
            if (blocks.charAt(j) == 'W')
                c++;

            res = Math.min(res, c);

            i++;
            j++;
        }
        return res;
    }
}
