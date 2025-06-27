class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase(); // Convert entire string to lowercase
        int i = 0, j = s.length() - 1;

        while (i < j) {
            // Skip non-alphabetic characters
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;

            // Compare the characters
            if (s.charAt(i) != s.charAt(j)) return false;

            i++;
            j--;
        }

        return true;
    }
}
