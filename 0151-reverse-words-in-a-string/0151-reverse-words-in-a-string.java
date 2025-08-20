class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        // Step 1: reverse whole string
        reverse(arr, 0, n - 1);

        int i = 0, l = 0, r = 0;

        // Step 2: reverse each word in place
        while (i < n) {
            while (i < n && arr[i] != ' ') {
                arr[r++] = arr[i++];
            }
            if (l < r) { // found a word
                reverse(arr, l, r - 1);
                if (r < n)
                arr[r++] = ' '; // add space after word
                l = r;
            }
            i++;
        }

        // Step 3: return substring (trim trailing space)
        return new String(arr, 0, r > 0 && arr[r - 1] == ' ' ? r - 1 : r);
    }

    private void reverse(char[] arr, int l, int r) {
        while (l < r) {
            char tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            l++;
            r--;
        }
    }
}
