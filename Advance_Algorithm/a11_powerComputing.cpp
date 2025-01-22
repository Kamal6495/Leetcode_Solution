#include <bits/stdc++.h>
using namespace std;

/**
 * Naive approach to calculate power.
 * 
 * Time Complexity: O(p)
 * - The loop runs `p` times, where `p` is the exponent.
 * 
 * Space Complexity: O(1)
 * - Constant space usage as only a few variables are used.
 */
int powerNaive(int x, int p) {
    int power = x;

    if (x == 1)   // Edge case: 1^p is always 1
        return 1;
    if (p == 0)   // Any number raised to the power of 0 is 1
        return 1;

    // Loop p-1 times to multiply x with itself
    for (int i = 1; i < p; i++) {
        power *= x;  // Multiply current power value by x
    }

    return power;
}

/**
 * Efficient approach to calculate power using exponentiation by squaring.
 *
 * This method takes advantage of the fact that:
 * - If p is even: x^p = (x^2)^(p/2)
 * - If p is odd: x^p = x * x^(p-1)
 *
 * Time Complexity: O(log p)
 * - The loop divides `p` by 2 in each iteration, making it logarithmic in `p`.
 * 
 * Space Complexity: O(1)
 * - Only a few variables are used, so the space usage is constant.
 */
int powerEfficient(int x, int p) {
    int power = 1;  // Initialize result to 1

    if (x == 1)     // Edge case: 1^p is always 1
        return 1;
    if (p == 0)     // Any number raised to the power of 0 is 1
        return 1;

    // Loop to apply the efficient exponentiation by squaring
    while (p > 0) {
        if (p % 2 == 1) {   // If p is odd, multiply result by current x
            power *= x;
        }

        // Square the base (x = x^2) for the next iteration
        x *= x;

        // Divide p by 2 (to reduce the problem size)
        p /= 2;
    }

    return power;
}

int main() {
    // Test both power functions with base = 2, exponent = 4
    cout << "Naive method: " << powerNaive(2, 4) << endl;
    cout << "Efficient method: " << powerEfficient(2, 4) << endl;

    return 0;
}
