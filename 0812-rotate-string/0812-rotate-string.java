class Solution {
  public boolean rotateString(String s, String goal) {
    if (s.length() != goal.length())
      return false;
    for (int i = 0; i < s.length(); i++) {
      String res = leftRotate(s, i);
      if (res.equalsIgnoreCase(goal))
        return true;
    }
    return false;

  }

  public String leftRotate(String s, int i) {
    char s1[] = s.toCharArray();
    reverse(s1, 0, i);
    reverse(s1, i + 1, s.length() - 1);
    reverse(s1, 0, s.length() - 1);
    return String.valueOf(s1);
  }

  public String reverse(char s[], int i, int j) {

    while (i < j) {
      char c = s[i];
      s[i] = s[j];
      s[j] = c;
      i++;
      j--;
    }
    return String.valueOf(s);
  }
}