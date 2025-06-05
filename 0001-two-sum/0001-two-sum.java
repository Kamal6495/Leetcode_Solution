class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            int rem = target - x;

            if (!map.containsKey(rem))
                map.put(nums[i], i);
            else
                return new int[] { i, map.get(rem) };
        }
        return new int[] {};
    }
}