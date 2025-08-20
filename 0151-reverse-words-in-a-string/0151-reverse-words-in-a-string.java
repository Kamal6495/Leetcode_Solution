class Solution {
  public String reverseWords(String s) {

      int leading = 0, trailing = s.length() - 1;
      while (leading < s.length() && s.charAt(leading) == ' ') leading++;
      while (trailing >= 0 && s.charAt(trailing) == ' ') trailing--;

      s = s.substring(leading, trailing + 1);

      String res = "";
      int a = 0;

      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == ' ') {
          // avoid multiple spaces
          if (s.charAt(i - 1) != ' ') {
            String token = s.substring(a, i);
            if (res.isEmpty()) {
              res = token;
            } else {
              res = token + " " + res; // ✅ prepend to reverse
            }
          }
          a = i + 1;
        }
      }

      // last word (since no trailing space after last word)
      String token = s.substring(a);
      if (!token.isEmpty()) {
        if (res.isEmpty()) res = token;
        else res = token + " " + res;
      }

      return res;
  }
}
