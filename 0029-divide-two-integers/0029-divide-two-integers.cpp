class Solution {
public:
    int divide(int dividend, int divisor) {
        // using bitwise operatins

        /*XOR is true if the two operands are different.
        XOR is false if the two operands are the same.*/
        // Handle overflow
        if (dividend == divisor)
            return 1;

        if (dividend == INT_MIN && divisor == -1)
            return INT_MAX;
             if (dividend == INT_MAX && divisor == -1)
            return INT_MIN+1;


        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;

        long n = abs((long)dividend);
        long d = abs((long)divisor);
        int count;
        long ans=0;
        while (n >= d) {
            count = 0;

            while (n >= (d << (count + 1)))
                count++;

            ans = ans + (1LL << count);

            n = n - (d << count);
        }

        if (ans == INT_MAX && sign == 1)
            return INT_MAX;
        if (ans == INT_MAX && sign == -1)
            return INT_MIN;


        return sign * ans;
    }
};