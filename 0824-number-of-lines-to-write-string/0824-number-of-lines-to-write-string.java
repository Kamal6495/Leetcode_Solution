class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int[] res = new int[2];
        
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += widths[s.charAt(i) - 97];
            if (sum > 100) {
                res[0] += 1;
                sum = widths[s.charAt(i) - 97];

            }

        }
        res[1] = sum;
         res[0] += 1;
        return res;
    }
}