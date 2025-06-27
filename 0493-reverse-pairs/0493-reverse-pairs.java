class Solution {

    public int mergeSort(int arr[], int low, int high) {
        int cnt = 0;
        if (low >= high)
            return cnt;
        int mid = low + ((high - low) / 2);
        cnt+=mergeSort(arr, low, mid);
        cnt+=mergeSort(arr, mid + 1, high);
        cnt+=countPairs(arr,low,mid,high);
        merge(arr, low, mid, high);
        return cnt;
    }
    public int countPairs(int arr[],int low,int mid,int high){
        int right=mid+1;
        int cnt=0;

        for(int left=low;left<=mid;left++){
        
        while(right<=high && (long)arr[left]>arr[right]*2L) right++;
        cnt+=(right-(mid+1));
        }
        return cnt;
    }

    public int merge(int arr[], int low, int mid, int high) {
        int cnt = 0;
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int left[] = new int[n1];
        int right[] = new int[n2];
        for (int i = 0; i < n1; i++)
            left[i] = arr[low + i];
        for (int i = 0; i < n2; i++)
            right[i] = arr[mid + i + 1];

        // int rr = mid + 1;
        // for (int ll = low; ll <= mid; ll++) {
        //     while ((rr <= high) && ((long) arr[ll] > 2L * arr[rr]))
        //         rr++;
        //     cnt += (rr - (mid + 1));
        // }

        int i = 0, j = 0, k = low;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < n1) {
            arr[k++] = left[i++];
        }
        while (j < n2) {
            arr[k++] = right[j++];
        }

        return cnt;
    }

    public int reversePairs(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }
}