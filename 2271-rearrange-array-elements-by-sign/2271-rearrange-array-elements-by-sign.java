class Solution {
    public int[] rearrangeArray(int[] arr) {
        int x = 0, y = 0;
        int n = arr.length;
        int res[] = new int[n];
       

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                res[2*x] = arr[i];
                x++;
            }
            if (arr[i] < 0) {
                res[2*y+1] = arr[i];
                y++;
            }
        }


        return res;
    }
}