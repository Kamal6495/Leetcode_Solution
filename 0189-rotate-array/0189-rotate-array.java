class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k=k%n;
        reverse(nums, 0, n);
      //  System.out.println(Arrays.toString(nums));
        reverse(nums, 0, k);
        
       // System.out.println(Arrays.toString(nums));
        reverse(nums, k, n);

      //  System.out.println(Arrays.toString(nums));
    }

    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j - 1];
            nums[j - 1] = temp;
            i++;
            j--;
        }

    }
}