class Solution {
    public int findMaxConsecutiveOnes(int[] arr) {
        int max1 = 0, cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                cnt++;
                max1 = Math.max(max1, cnt);
            } else
                cnt = 0;
        }
        return max1;
    }
}