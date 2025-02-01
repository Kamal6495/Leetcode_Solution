class Solution {
    public String getPermutation(int n, int k) {

       
        String ans = "";

        List<Integer> numbers = new ArrayList<>();

        int fact = 1;

        for (int i = 1; i < n; i++) {
            numbers.add(i);
            fact *= i;
        }
        numbers.add(n);
        int kth = k - 1;

        while (true) {
            ans = ans + numbers.get(kth / fact).toString();
            numbers.remove(kth / fact);

            if (numbers.size() == 0)
                break;
            kth = kth % fact;
            fact = fact / numbers.size();

        }
        return ans;

    }
}