class Solution {
  public String longestCommonPrefix(String[] strs) {
    int n = strs.length;
    int j = 0;
    String s1 = "";
    int minLen = Integer.MAX_VALUE;
    for (String s : strs)
      minLen = Math.min(minLen, s.length());

    for (int i = 0; i < minLen; i++) {

      char c = strs[0].charAt(j);
      for (int k = 1; k < n; k++) {
        if (c != strs[k].charAt(j))
          return strs[0].substring(0, j);
      }
      j++;

    }
    return strs[0].substring(0, j);
  }
}