class Solution {
  public String removeOuterParentheses(String s) {
    String res = "";
    int depth = 0;
    for (char c : s.toCharArray()) {
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