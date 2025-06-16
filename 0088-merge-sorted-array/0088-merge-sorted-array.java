class Solution {
    //Using Shell Sort Gap Method , Optimal Solution 2
    public void merge(int[] arr1, int m, int[] arr2, int n) {
        int m1=m;
        for (int num : arr2) {
            arr1[m1++] = num;
        }
      //  System.out.println(Arrays.toString(arr1));
        // int gap=(int)Math.ciel((m+n)*0.5);
        int gap = ((m + n) / 2) + ((m + n) % 2);
        while (gap >= 1) {
           
            int left = 0;
            int right = gap;
            while (right < m+n) {
                if (arr1[left] > arr1[right]) {
                    int temp = arr1[left];
                    arr1[left] = arr1[right];
                    arr1[right] = temp;

                }
                left++;
                right++;
            }
            if(gap==1) break;
            gap = (gap / 2) + (gap % 2);
        }
    }
}