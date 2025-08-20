class Solution {
  public String removeOuterParentheses(String s) {
    String res = "";
    int depth = 0;
    for (int i=0;i<s.length();i++) {
      char c=s.charAt(i);
      if (c == '(') {
        if (depth > 0)
          res += c;
        depth++;
      } else {
        depth--;
        if (depth > 0)
          res += c;

      }
    }

    return res;
  }
}