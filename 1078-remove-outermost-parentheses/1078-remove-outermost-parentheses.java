class Solution {
  public String removeOuterParentheses(String s) {
    String res = "";
    Stack<Character> st = new Stack<>();
    for (char c : s.toCharArray()) {
      if (c == '(') {
        if (!st.isEmpty())
          res += c;
        st.push(c);
      } else {
        st.pop();
        if (!st.isEmpty())
          res += c;
     
      }
    }

    return res;
  }
}