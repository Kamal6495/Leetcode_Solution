class Solution { // Modified Kadane's Algorithm
    public int maxProduct(int[] nums) {
        // Initialize global result to the first element
        int maxProduct = nums[0];

        // These track the max and min products ending at the current position
        int minEnding = nums[0]; // smallest product ending at i
        int maxEnding = nums[0]; // largest product ending at i

        // Iterate through the array starting from index 1
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];

            // ❗ If current number is negative, swap max and min
            // because multiplying by negative flips their roles
            if (curr < 0) {
                int temp = maxEnding;
                maxEnding = minEnding;
                minEnding = temp;
            }

            // Calculate max/min product ending at this index
            // Either start new subarray at curr or extend previous subarray
            maxEnding = Math.max(curr, maxEnding * curr);
            minEnding = Math.min(curr, minEnding * curr);

            // Update the global maximum product so far
            maxProduct = Math.max(maxProduct, maxEnding); // ❗Fixed 'Math.Max' to 'Math.max'
        }

        return maxProduct;
    }
}
