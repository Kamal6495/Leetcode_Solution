class Solution {
public:
    string getPermutation(int n, int k) {
        string res = "";

        int fact = 1;
        vector<int> numbers;

        for (int i = 1; i < n; i++) {

            numbers.push_back(i);
            fact = fact * i;
        }
        numbers.push_back(n);
        int kth = k - 1; // oth indexeing

        while (true) {

            res += to_string(numbers[kth / fact]);
            numbers.erase(numbers.begin() + (kth / fact));
            if (numbers.size() == 0)
                break;
            kth = kth % fact;
            fact = fact / numbers.size();
        }
        return res;
    }
};