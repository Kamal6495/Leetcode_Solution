class Solution {

    /**
     * Using List<String> ds = new ArrayList<>(); is generally better for
     * maintainability and flexibility, following good software design principles.
     * Using ArrayList<String> ds = new ArrayList<>(); is acceptable if you are
     * certain you'll always use ArrayList and don't need flexibility.
     */
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();

        solve(0, s, s.length(), ans, new ArrayList<>());
        return ans;
    }

    public boolean isPalindrome(int l, int r, String s) {

        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }

        return true;
    }

    public void solve(int ind, String s, int n, List<List<String>> ans, List<String> ds) {
        if (ind == n) {
            ans.add(new ArrayList<>(ds));
            return;

        }

        for (int i = ind; i < n; i++) {

            if (isPalindrome(ind, i, s)) {
                ds.add(s.substring(ind, i + 1));
                solve(i + 1, s, n, ans, ds);
                ds.remove(ds.size() - 1);

            }
        }

    }
}