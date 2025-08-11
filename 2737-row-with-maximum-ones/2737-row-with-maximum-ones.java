class Solution {
    public int[] rowAndMaximumOnes(int[][] arr) {
         int index = -1;
        int max_cnt = -1;
        
        for (int i = 0; i < arr.length; i++) {
            int cntrow = 0;
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1) cntrow++;
            }
            if (cntrow > max_cnt) {
                max_cnt = cntrow;
                index = i;
            }
        }
        
        return new int[]{index, max_cnt};
    }
}