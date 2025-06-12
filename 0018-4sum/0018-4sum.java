class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> t = new HashSet<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];

                    if (sum < (long) target) {
                        k++;
                    } else if (sum > (long) target) {
                        l--;
                    } else {
                        List<Integer> quad = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        Collections.sort(quad);
                        t.add(quad);
                        
                        while (k < l && nums[k] == nums[k + 1])
                            k++;
                        while (k < l && nums[l] == nums[l - 1])
                            l--;

                            k++;
                        l--;

                    }
                }

            }
        }

        for (List<Integer> x : t) {
            res.add(x);
        }
        return res;
    }
}