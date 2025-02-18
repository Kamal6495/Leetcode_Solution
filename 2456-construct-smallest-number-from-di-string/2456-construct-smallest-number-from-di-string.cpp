class Solution {
public:
    string smallestNumber(string p) {
        stack<int> st;
        int n = p.size();
        string s = "";

        for (int i = 0; i <= n; i++) {

            st.push(i + 1);

            if (i == n || p[i] == 'I') {
                while (!st.empty()) {
                    s += to_string(st.top());
                    st.pop();
                }
            }
        }
        return s;
    }
};