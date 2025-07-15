class Solution {
    //Binary Method T(n)= O(2Log(n))
    //Using Upper and Lower Bound Concept

    public int LB(int[] arr, int n, int target) {
        int low = 0;
        int high = n - 1;
        int ans = n;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (arr[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return ans;
    }

    public int UB(int[] arr, int n, int target) {
        int low = 0;
        int high = n - 1;
        int ans = n;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (arr[mid] > target) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return ans;
    }

    public int[] searchRange(int[] nums, int target) {
        int lb = LB(nums, nums.length, target);
        if (lb == nums.length || nums[lb] != target)
            return new int[] { -1, -1 };

        int ub = UB(nums, nums.length, target);

        return new int[] { lb, ub - 1 };
    }
}