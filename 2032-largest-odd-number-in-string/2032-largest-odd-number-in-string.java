class Solution {
  public String largestOddNumber(String num) {
    int n = num.length();
    String maxOdd = "";
    int i;
    for (i = num.length() - 1; i >= 0; i--) {
      int digit = num.charAt(i) - '0';
      if (digit % 2 != 0)
        break;
    }

    return num.substring(0, i + 1);
  }
}