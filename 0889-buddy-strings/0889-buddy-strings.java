class Solution {
    public boolean buddyStrings(String s, String goal) {

        if (s.length() != goal.length())
            return false;

        if (s.equalsIgnoreCase(goal)) {

            Set<Character> cc = new HashSet<>();
            for (char c : goal.toCharArray()) {
                cc.add(c);
            }

            if (cc.size() < s.length())
                return true;
            else
                return false;
        }

        int count = 0;
        int fc = -1, sc = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                count++;
                if (count > 2)
                    return false;

                if (fc == -1)
                    fc = i;
                else
                    sc = i;
            }

        }
        //System.out.println(fc + " " + sc);

        return (count == 2 && (s.charAt(fc) == goal.charAt(sc) && s.charAt(sc) == goal.charAt(fc)));

    }
}