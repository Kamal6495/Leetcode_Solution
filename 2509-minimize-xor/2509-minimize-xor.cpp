class Solution {
public:
    int minimizeXor(int num1, int num2) {
        int bits = __builtin_popcount(num2);

        if (num1 == num2)
            return num1;

        int c = 0;

        for (int i = 31; i >= 0 & bits > 0; i--) {

            if (num1 & (1 << i)) {
                bits--;
                c = c + (1 << i);
            }
        }

        for (int j = 0; j < 32 & bits > 0; j++) {
            if ((num1 & (1 << j)) == 0) {
                bits--;
                c = c + (1 << j);
            }
        }

        return c;
    }
};