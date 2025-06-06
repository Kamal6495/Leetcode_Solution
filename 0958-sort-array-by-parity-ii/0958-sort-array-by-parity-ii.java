class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int odd = 0, even = 0;
        int arr[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                arr[2 * even] = nums[i];
                even++;
            } else {
                arr[2 * odd + 1] = nums[i];
                odd++;

            }
        }
        return arr;
    }
}