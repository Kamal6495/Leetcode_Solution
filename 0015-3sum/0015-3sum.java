class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> temp = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            Set<Integer> st = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                List<Integer> ls = new ArrayList<>();
                if (st.contains((-1 * (nums[i] + nums[j])))) {
                    ls.addAll(Arrays.asList(nums[i], nums[j], (-1 * (nums[i] + nums[j]))));
                    Collections.sort(ls);
                    temp.add(ls);
                }
                st.add(nums[j]);
            }
        }
        for (List<Integer> x : temp)
            res.add(x);

        return res;
    }
}