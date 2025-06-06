class Solution {
    public int[] rearrangeArray(int[] arr) {
        int x = 0, y = 0;
        int n = arr.length;
        int pos[] = new int[n / 2];
        int neg[] = new int[n / 2];

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                pos[x] = arr[i];
                x++;
            }
            if (arr[i] < 0) {
                neg[y] = arr[i];
                y++;
            }
        }

        for (int i = 0; i < n / 2; i++) {
            arr[2 * i] = pos[i];
            arr[2 * i + 1] = neg[i];
        }
        return arr;
    }
}