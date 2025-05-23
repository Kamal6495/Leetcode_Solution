class Solution {
    public int[] sortArray(int[] nums) {
        mergesort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergesort(int arr[], int LB, int UB) {

        if (LB >= UB)
            return;//base case

        int MID = LB + ((UB - LB) / 2);

        mergesort(arr, LB, MID);
        mergesort(arr, MID + 1, UB);
        merge(arr, LB, MID, UB);
    }

    public void merge(int arr[], int LB, int MID, int UB) {
        int n1 = MID - LB + 1;
        int n2 = UB - MID;
        int n = n1 + n2;
        int left[] = new int[n1];
        int right[] = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = arr[i+LB];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = arr[j+MID+1];
        }

        int i = 0, j = 0, k = LB;

        while (i < n1 && j < n2) {

            if (left[i] < right[j]) {
                arr[k] = left[i];
                i++;

            } else if(left[i]>right[j]) {
                arr[k] = right[j];
                j++;
            }
            else{
                arr[k]=left[i];
                arr[++k]=right[j];
                i++;j++;
            }

            k++;
        }

        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }
}