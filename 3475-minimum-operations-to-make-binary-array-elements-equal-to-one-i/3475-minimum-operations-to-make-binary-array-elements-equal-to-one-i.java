class Solution {
    public int minOperations(int[] nums) {
            int n=nums.length;
        int res = 0;
        for (int i = 0; i <= nums.length - 3;i++) {
            int j = i;
            if (nums[i] == 0) {
               
                while (j < i + 3) {
                    nums[j] = nums[j] ^ 1;
                    j++;
                }
                res++;
            }
             

        }

        if(nums[n-1]==1 &&  nums[n-2]==1)

        return  res;

        return -1;
    }
}