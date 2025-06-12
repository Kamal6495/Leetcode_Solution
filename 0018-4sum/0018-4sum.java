class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> t = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Long> hs = new HashSet<>();
                for (int k = j + 1; k < n; k++) {

                    long a = nums[i]; long b = nums[j]; long c = nums[k];
                    long l = (long) target - a -  b - c;

                    if (hs.contains(l)) {
                       List<Integer> quad = Arrays.asList((int) a, (int) b, (int) c, (int) l);
                        Collections.sort(quad);
                        t.add(quad);
                    }
                    hs.add((long)nums[k]);

                    
                }
            }
        }

        for (List<Integer> x : t) {
            res.add(x);
        }
        return res;
    }
}