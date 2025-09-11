class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;

        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            // rotate by moving first char to end
            char first = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(first);

            if (sb.toString().equals(goal)) {
                return true;
            }
        }
        return false;
    }
}
