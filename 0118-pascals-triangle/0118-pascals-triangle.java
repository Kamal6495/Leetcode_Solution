class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {
            result.add(getRow(i));
        }
        return result;
    }

    public List<Integer> getRow(int rowIndex) {
        int N = rowIndex;
        long ans = 1;
        List<Integer> res = new ArrayList<>();
        res.add(1);

        for (int i = 1; i < N; i++) {
            ans = ans * (long) (N - i);
            ans = ans / (long) i;
            res.add((int) ans);
        }

        return res;
    }
}