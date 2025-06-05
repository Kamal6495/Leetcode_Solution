class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate)
                count++;
            else
                count--;
            if (count == 0) {
                if (i + 1 < nums.length)
                    candidate = nums[i + 1];

            }
        }
        return candidate;
    }
}