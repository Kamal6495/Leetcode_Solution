class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        auxComb(0, candidates.length, candidates, new ArrayList<>(), ans, target);
        return ans;
    }

    public void auxComb(int ind, int n, int[] arr, List<Integer> ds, List<List<Integer>> ans, int target) {

        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = ind; i < n; i++) {

            if (i > ind && arr[i] == arr[i - 1])
                continue;// duplicate found is skipped
            if (arr[i] > target)
                break;

            ds.add(arr[i]);
            auxComb(i + 1, n, arr, ds, ans, target - arr[i]);
            ds.remove(ds.size() - 1);

        }

    }
}