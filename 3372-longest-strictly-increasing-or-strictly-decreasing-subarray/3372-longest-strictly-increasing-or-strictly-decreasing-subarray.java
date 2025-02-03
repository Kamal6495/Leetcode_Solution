class Solution {
    public int longestMonotonicSubarray(int[] arr) {
        int countI = 1, countD = 1, ans = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                countI++;
                countD = 1;
            } else if (arr[i] < arr[i - 1]) {
                countD++;
                countI = 1;
            } else {
                countD = countI = 1;
            }
            ans = Math.max(ans, Math.max(countD, countI));

        }
        return ans;
    }
}