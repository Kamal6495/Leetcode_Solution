class Solution {
public:
    int BS1(vector<int>& nums, int n) {
        int low = 0, high = n - 1, mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (mid == n - 1 || (nums[mid] < 0 && nums[mid + 1] >= 0))
                return mid;
            else if (nums[mid] < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    int BS2(vector<int>& nums, int n) {

        int low = 0, high = n - 1, mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (mid == 0 || (nums[mid] > 0 && nums[mid - 1] <= 0))
                return mid;
            else if (nums[mid] > 0)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    int maximumCount(vector<int>& nums) {
        int n = nums.size();

        if(n == 1 && nums[0] == 0)
            return 0;

        int x = BS1(nums, n);
        int y = BS2(nums, n);

        int neg = x + 1;
        int pos = (y == -1)? 0 : n - y;

        return max(pos, neg);
    }
};