class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int lines = 1, sum = 0;

        for (char c : s.toCharArray()) {
            int width = widths[c - 'a'];
            if (sum + width > 100) {
                lines++;
                sum = width; //  line starts with current character
            } else {
                sum += width;
            }
        }

        return new int[]{lines, sum};
    }
}
