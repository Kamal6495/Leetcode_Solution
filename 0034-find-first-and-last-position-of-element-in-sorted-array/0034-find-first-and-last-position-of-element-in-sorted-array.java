class Solution {
    //Linear Method T(n)= O(n)
    public int[] searchRange(int[] nums, int target) {
        int F = -1, L = -1;
        for (int i=0;i<nums.length;i++) {
            if (F == -1 && L == -1 && nums[i] == target)
                F = i;
            if (nums[i] == target)
                L = i;
        }

        return new int[] { F, L };
    }
}