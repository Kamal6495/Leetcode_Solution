class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length - 1;

        int low = 0;
        int high = n;
        return fun(nums, low, high, target);
    }

    public int fun(int arr[], int low, int high, int target) {
        if (low > high)
            return -1;
        int mid = low + ((high - low) / 2);
        if (arr[mid] == target)
            return mid;
        else if (target > arr[mid])
            return fun(arr, mid + 1, high, target);
        else
            return fun(arr, low, mid - 1, target);
    }
}