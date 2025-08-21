class Solution {
  public String longestCommonPrefix(String[] strs) {
    int n = strs.length;
    int j = 0;
    String s1 = "";
    int minLen = Integer.MAX_VALUE;
    for (String s : strs)
      minLen = Math.min(minLen, s.length());

    for (int i = 0; i < minLen; i++) {
      s1 = strs[0].substring(0, j + 1);
      for (int k = 1; k < n; k++) {
        if (!s1.equalsIgnoreCase(strs[k].substring(0, j + 1)))
          return strs[0].substring(0, j);
      }
      j++;

    }
    return s1;
  }
}