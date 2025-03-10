class Solution {
    public boolean isHappy(int n) {
        Set<Integer> te = new HashSet<>();

        while (n != 1 && !te.contains(n)) {
            te.add(n);
            int sum = 0;
            while (n > 0) {
                int rem = n % 10;
                sum += rem * rem;
                n /= 10;

            }
            n = sum;
        }

        return n == 1;
    }
}