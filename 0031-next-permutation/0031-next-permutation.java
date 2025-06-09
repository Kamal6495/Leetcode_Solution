class Solution {

    public void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void reverse(int arr[],int i,int j){
        while(i<j){
           swap(arr,i,j);
            i++;j--;
        }
     }

    public void nextPermutation(int[] arr) {
        int ind = -1;
        int n = arr.length;

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                ind = i;
                break;
            }
        }

        if (ind == -1) {
            reverse(arr, 0, n - 1);
            return;
        }

        for (int i = n - 1; i >= ind; i--) {
            if (arr[i] > arr[ind]) {
                swap(arr, i, ind);
                break;
            }
        }

        reverse(arr, ind + 1, n - 1);
    }
}