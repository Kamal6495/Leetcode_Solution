import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> freq1 = new HashMap<>();
        HashMap<Integer, Integer> freq2 = new HashMap<>();

        // Count frequency in nums1
        for (int num : nums1) {
            freq1.put(num, freq1.getOrDefault(num, 0) + 1);
        }

        // Count frequency in nums2
        for (int num : nums2) {
            freq2.put(num, freq2.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer> resultList = new ArrayList<>();
        for (Integer key : freq1.keySet()) {
            if (freq2.containsKey(key)) {
                resultList.add(key); // present in both arrays
            }
        }

        // Convert ArrayList to int[]
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}
