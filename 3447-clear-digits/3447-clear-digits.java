class Solution {
    public String clearDigits(String s) {
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {

            if (Character.isDigit(c) && !st.empty()) {

                st.pop();
            } else
                st.push(c);
        }

        String result = "";
        for (char c : st) {
            result += c;
        }

        return result.toString();

    }

}