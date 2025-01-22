#include <bits/stdc++.h>
using namespace std;

/*
 * Function to compute the power of a number n raised to p using an iterative approach.
 * This function implements exponentiation by squaring.
 *
 * Parameters:
 * n - the base (integer)
 * p - the exponent (integer)
 *
 * The method works by repeatedly squaring the base (x) and multiplying it to the result
 * only when the exponent (p) is odd. This allows us to compute the result in a logarithmic number
 * of steps.
 *
 * Time Complexity: O(log(p)) - The exponent is divided by 2 in each iteration, leading to logarithmic time complexity.
 * Space Complexity: O(1) - Only a few variables are used, and no extra space is required.
 */
void iterativePower(int n, int p)
{
    int res = 1; // Initialize result as 1 (n^0 = 1)
    int x = n;   // x holds the current base value

    // Loop continues as long as the exponent p is greater than 0
    while (p > 0)
    {
        // If p is odd, multiply the current result by x
        if (p % 2 == 1)
        {
            res = res * x; // Multiply the result by the current base
        }
        // Halve the exponent (p = p / 2)
        p /= 2;
        // Square the base value for the next iteration
        x = x * x;
    }

    // Output the result after all iterations
    cout << res << endl; // T(n) = O(log(p))
}

/*
 * Function to compute the power of a number n raised to p using bitwise operations.
 * This function is similar to the previous one, but uses bitwise operators for optimization.
 *
 * Parameters:
 * n - the base (integer)
 * p - the exponent (integer)
 *
 * Instead of using the modulus operator (p % 2), we use bitwise AND to check if the exponent is odd.
 * Instead of dividing by 2 (p /= 2), we use the right shift operator (p >> 1) to halve the exponent.
 *
 * Time Complexity: O(log(p)) - The exponent is divided by 2 (via right shift) in each iteration, resulting in logarithmic time.
 * Space Complexity: O(1) - No extra space is used apart from a few variables.
 */
void iterativePowerBitwise(int n, int p)
{
    int res = 1; // Initialize result as 1 (n^0 = 1)
    int x = n;   // x holds the current base value

    // Loop continues as long as the exponent p is greater than 0
    while (p > 0)
    {
        // If the least significant bit of p is 1 (p is odd), multiply the result by x
        if (p & 1)
        {
            res = res * x; // Multiply the result by the current base
        }
        // Right shift the exponent by 1 (equivalent to dividing p by 2)
        p = p >> 1;
        // Square the base value for the next iteration
        x = x * x;
    }

    // Output the result after all iterations
    cout << res << endl; // T(n) = O(log(p))
}

int main()
{
    // Test both functions with base 4 and exponent 5
    iterativePower(4, 5);        // Expected output: 1024 (4^5 = 1024)
    iterativePowerBitwise(4, 5); // Expected output: 1024 (4^5 = 1024)
}
