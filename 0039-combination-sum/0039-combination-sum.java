class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        auxCom(0, candidates.length,candidates,ans, target, new ArrayList<>());

        return ans;

    }

    public void auxCom(int i, int n, int arr[], List<List<Integer>> ans, int target, List<Integer> ds) {

        if (i == n) {

            if (target == 0)
                ans.add(new ArrayList<>(ds) );
            return;
        }

        if (arr[i] <= target) {
            ds.add(arr[i]);

            auxCom(i, n, arr, ans, target - arr[i], ds);
            ds.remove(ds.size() - 1);// last element remove

        }

        auxCom(i+1, n, arr, ans, target, ds);
    }
}