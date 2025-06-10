class Solution {
    public List<Integer> getRow(int rowIndex) {
        int N = rowIndex + 1;
        long ans = 1;
        List<Integer> res = new ArrayList<>();
        res.add(1);

        for (int i = 1; i < N; i++) {
            ans = ans * (long)(N - i);
            ans = ans / (long)i;
            res.add((int)ans);
        }

        return res;
    }
}