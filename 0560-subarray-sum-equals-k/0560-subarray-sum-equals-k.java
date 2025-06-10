class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int presum = 0, count = 0;
        mp.put(0, 1);
        for (int num : nums) {
            presum += num;
            int rem = presum - k;
            count += mp.getOrDefault(rem, 0);
            mp.put(presum, mp.getOrDefault(presum, 0) + 1);
        }
        return count;
    }
}