class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        auxPermute(0, nums.length, nums, res);
        return res;
    }

    public static void auxPermute(int ind, int n, int ds[], List<List<Integer>> res) {
        if (ind == n) {
            List<Integer> temp = new ArrayList<>();
            for (int num : ds)
                temp.add(num);
            res.add(temp);
        }

        for (int i = ind; i < n; i++) {
            swap(ds, i, ind);
            auxPermute(ind + 1, n, ds, res);
            swap(ds, ind, i);

        }
    }

    public static void swap(int[] ds, int i, int j) {
        int temp = ds[i];
        ds[i] = ds[j];
        ds[j] = temp;
    }

}