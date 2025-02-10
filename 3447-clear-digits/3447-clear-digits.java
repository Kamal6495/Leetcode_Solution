class Solution {
    public String clearDigits(String s) {
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {

            if (Character.isDigit(c) && !st.empty()) {

                st.pop();
            } else
                st.push(c);
        }

        StringBuilder result = new StringBuilder() ;
        for (char c : st) {
            result.append(c);
        }

        return result.toString();

    }

}