class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
Arrays.sort(nums);
        auxSubset(0, nums.length, nums, new ArrayList<>(), ans);
        return ans;
    }

    public void auxSubset(int ind, int n, int[] arr, List<Integer> ds, List<List<Integer>> ans) {


ans.add(new ArrayList<>(ds));
        

        for (int i = ind; i < n; i++) {

            if (i > ind && arr[i] == arr[i - 1])
                continue;

            ds.add(arr[i]);
            auxSubset(i + 1, n, arr, ds, ans);
            ds.remove(ds.size() - 1);

        }

    }
}