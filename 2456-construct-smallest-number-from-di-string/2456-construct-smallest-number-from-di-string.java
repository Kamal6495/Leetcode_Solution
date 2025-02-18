class Solution {
    public String smallestNumber(String p) {
        Stack<Integer> st = new Stack<>();
        StringBuilder s = new StringBuilder();
        int n = p.length();

        for (int i = 0; i <= n; i++) {

            st.push(i + 1);

            if (i == n || p.charAt(i) == 'I') {
                while (!st.empty()) {
                    s.append(st.pop());
                }

            }
           // System.out.println(i);
        }

        return s.toString();
    }
}