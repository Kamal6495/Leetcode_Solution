class Solution {


    public void merge(int[] arr1, int m, int[] arr2, int n) {
        int left = m - 1;
        int right = 0;

        while (left >= 0 && right < n) {
            if (arr1[left] > arr2[right]) {
                int temp = arr1[left];
                arr1[left] = arr2[right];
                arr1[right + m] = temp;
                left--;
                right++;
            } else
                break;

        }
        while (right < n) {
            arr1[right + m] = arr2[right];
            right++;
        }
        Arrays.sort(arr1);

    }
}