class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int tr = 0, rc = matrix[0].length - 1;
        int lc = 0, br = matrix.length - 1;
        List<Integer> res = new ArrayList<>();
        while (tr <= br && lc <= rc) {

            for (int i = lc; i <= rc; i++)
                res.add(matrix[tr][i]);
            tr++;

            for (int i = tr; i <= br; i++)
                res.add(matrix[i][rc]);
            rc--;

            if (tr <= br) {
                for (int i = rc; i >= lc; i--)
                    res.add(matrix[br][i]);
                br--;
            }

            if (lc <= rc) {

                for (int i = br; i >= tr; i--)
                    res.add(matrix[i][lc]);
                lc++;
            }
        }

        return res;
    }
}