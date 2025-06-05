import java.util.HashMap;

class Solution {
    public int subarraySum(int[] arr, int k) {
        HashMap<Integer, Integer> presum = new HashMap<>();
        presum.put(0, 1);  // base case: one way to make sum 0
        int sum = 0;
        int count = 0;

        for (int num : arr) {
            sum += num;
            if (presum.containsKey(sum - k)) {
                count += presum.get(sum - k);
            }
            presum.put(sum, presum.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
