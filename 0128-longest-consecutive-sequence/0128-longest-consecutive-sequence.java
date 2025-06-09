class Solution {
    public int longestConsecutive(int[] arr) {
        Set<Integer> st = new HashSet<>();
        int n = arr.length;
        int longest = 0, cnt = 0;

        for (int num : arr) {
            st.add(num);
        }

        for (int ele : st) {

            if (!st.contains(ele - 1)) {
                cnt = 1;
                int x = ele;
                while (st.contains(x + 1)) {
                    x++;
                    cnt++;
                }

            }
            longest = Math.max(longest, cnt);
        }
        return longest;

    }
}