import java.util.*;
class Solution {
  public String reverseWords(String s) {
    StringTokenizer st = new StringTokenizer(s);
    String res = "";
    while (st.hasMoreTokens()) {
      res = st.nextToken() + " " + res;
    }
    return res.substring(0, res.length() - 1);
  }
}