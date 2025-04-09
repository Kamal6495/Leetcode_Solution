class Solution {
    public int minOperations(int[] nums, int k) {
        Set<Integer> set = new HashSet<>(); // To store unique values greater than k

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < k)
                return -1; // If any element is less than k, it's impossible to reach k, return -1

            if (nums[i] > k) {
                set.add(nums[i]); // Add unique values greater than k (each will need an operation)
            }
        }

        return set.size(); // Each unique value > k will require one operation to reduce to next valid h
    }
}