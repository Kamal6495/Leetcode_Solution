class Solution {
    //Linear Method T(n)= O(n)
    public int[] searchRange(int[] nums, int target) {
        int F = -1, L = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (F == -1)
                    F = i;
                L = i;
            }
        }

        return new int[] { F, L };
    }
}