class Solution {
    public int findPeakElement(int[] arr) {
        int n=arr.length;
        for(int i=0;i<n;i++){
            if((i==0 || arr[i-1]<arr[i]) && (i==n-1 || arr[i]>arr[i+1]))
            return i;
        }
        return -1;
    }
}