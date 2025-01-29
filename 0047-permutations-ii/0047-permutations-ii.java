import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums); // Sort to help skip duplicates
        auxPermute(0, nums.length, ans, nums);
        return ans;
    }

    public void auxPermute(int ind, int n, List<List<Integer>> ans, int nums[]) {
        if (ind == n) {
            List<Integer> perm = new ArrayList<>();
            for (int num : nums) {
                perm.add(num); // Add each element of the array to the list
            }
            ans.add(perm);
            return;
        }

        Set<Integer> used = new HashSet<>();
        for (int i = ind; i < n; i++) {
            if (used.contains(nums[i]) || (i > ind && nums[i] == nums[i - 1])) {
                continue; // Skip if the element is used already or a duplicate
            }
            used.add(nums[i]); // Mark element as used for this recursion level

            swap(i, ind, nums);
            auxPermute(ind + 1, n, ans, nums);
            swap(i, ind, nums); // backtrack
        }
    }

    public void swap(int i, int j, int arr[]) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
