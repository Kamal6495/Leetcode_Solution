#include <bits/stdc++.h>
using namespace std;

/**
 * Function to compute the Least Common Multiple (LCM) of two numbers
 * using a brute-force approach (Method A).
 *
 * The function divides the numbers a and b by the smallest prime factor
 * starting from 2 and continues until both numbers are reduced to 1.
 * The product of the prime factors gives the LCM.
 *
 * Time Complexity: O(max(a, b) * sqrt(min(a, b))) - The outer loop may run up to
 * a maximum of max(a, b) iterations, while the inner operations can be at most
 * sqrt(min(a, b)) for each iteration, due to the nature of prime factorization.
 *
 * Space Complexity: O(1) - Only a few integer variables are used.
 */
int lcmBruteA(int a, int b)
{
    int res = 1; // Initialize the result to 1
    int i = 2;   // Start checking for factors from 2

    // Loop until both a and b are reduced to 1
    while (a != 1 || b != 1)
    {
        cout << i << "|" << a << ", " << b << endl; // Debug output
        if (a % i == 0 && b % i == 0)               // Check if i divides both a and b
        {
            a /= i;        // Reduce a by i
            b /= i;        // Reduce b by i
            res = res * i; // Multiply the result by i
        }
        else if (a % i == 0) // If i divides only a
        {
            a /= i;        // Reduce a by i
            res = res * i; // Multiply the result by i
        }
        else if (b % i == 0) // If i divides only b
        {
            b /= i;        // Reduce b by i
            res = res * i; // Multiply the result by i
        }
        else
        {
            i++; // Move to the next integer
        }
    }
    cout << "LCM : ";

    return res; // Return the computed LCM
}

/**
 * Function to compute the Least Common Multiple (LCM) of two numbers
 * using a brute-force approach (Method B).
 *
 * This method starts from the maximum of a and b and checks
 * each successive integer until it finds one that is divisible by both.
 *
 * Time Complexity: O(max(a, b) * min(a, b)) - The worst-case scenario occurs
 * when the LCM is a large number relative to both a and b, requiring potentially
 * up to b checks for each increment.
 *
 * Space Complexity: O(1) - Only a few integer variables are used.
 */
int lcmBruteB(int a, int b)
{
    int res = max(a, b); // Start checking from the maximum of a and b

    // Loop indefinitely until a common multiple is found
    while (true)
    {
        if (res % a == 0 && res % b == 0) // Check if res is a multiple of both
            return res;                   // Return the first found multiple

        res++; // Increment res to check the next number
    }
}

/**
 * Function to compute the Greatest Common Divisor (GCD) of two numbers
 * using the Euclidean algorithm.
 *
 * The algorithm repeatedly replaces the larger number by the remainder of
 * dividing the larger number by the smaller until one of the numbers becomes zero.
 *
 * Time Complexity: O(log(min(a, b))) - The number of divisions required decreases exponentially.
 *
 * Space Complexity: O(1) - Only a few integer variables are used.
 */
int gcd(int a, int b)
{
    while (b != 0)
    {
        int remainder = a % b; // Find the remainder of a divided by b
        a = b;                 // Set a to b
        b = remainder;         // Set b to the remainder
    }
    return a; // When b becomes 0, a is the GCD
}

/**
 * Function to compute the Least Common Multiple (LCM) of two numbers
 * using the relationship between LCM and GCD.
 *
 * LCM(a, b) = |a * b| / GCD(a, b)
 *
 * As we Know Product of Two Number(a,b)=gcd(a,b)*lcm(a,b)
 *
 * Time Complexity: O(log(min(a, b))) - Due to the GCD calculation.
 *
 * Space Complexity: O(1) - Only a few integer variables are used.
 */
int lcmEffecient(int a, int b)
{
    return (a / gcd(a, b)) * b; // Calculate LCM using GCD
}

int main()
{
    int a = 48; // First number
    int b = 18; // Second number

    // Example: Computing the LCM using different methods
    cout << "LCM of " << a << " and " << b << " using Brute Force A is: \n"
         << lcmBruteA(a, b) << endl;
    cout << "LCM of " << a << " and " << b << " using Brute Force B is: " << lcmBruteB(a, b) << endl;
    cout << "LCM of " << a << " and " << b << " using GCD Property is: " << lcmEffecient(a, b) << endl;

    return 0;
}
