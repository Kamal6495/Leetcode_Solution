class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = minA(weights);
        int high = sumA(weights);
        int ans = weights.length;

        while(low<=high) {
          int mid=low+((high-low)/2);
            int presum = 0;
            int j = 0;
            int d = 1; // at least 1 day

            while (j < weights.length) {
                presum += weights[j++];

                if (presum > mid) {
                    d++;
                    presum = weights[j - 1];
                }
            }



            if (d <= days) { // ✅ Corrected condition
              ans=mid;
              high=mid-1;
            }
            else{
              low=mid+1;
            }
        }

        return ans;
    }

    public int minA(int[] arr) {
        int x = Integer.MIN_VALUE; 
        for (int num : arr)
            x = Math.max(x, num);
        return x;
    }

    public int sumA(int[] arr) {
        int x = 0;
        for (int num : arr)
            x += num;
        return x;
    }
}
