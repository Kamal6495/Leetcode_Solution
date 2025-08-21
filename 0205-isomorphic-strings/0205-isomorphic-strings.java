class Solution {
  public boolean isIsomorphic(String s, String t) {
    int n = s.length();

    Map<Character, Character> smp = new HashMap<>();
    Map<Character, Character> tmp = new HashMap<>();

    for (int i = 0; i < n; i++) {
      char s1 = s.charAt(i);
      char t1 = t.charAt(i);

      if (smp.containsKey(s1) && smp.get(s1) != t1)
        return false;
      if (tmp.containsKey(t1) && tmp.get(t1) != s1)
        return false;
      smp.put(s1, t1);
      tmp.put(t1, s1);
    }
    return true;
  }
}