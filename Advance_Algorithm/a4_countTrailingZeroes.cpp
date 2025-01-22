#include <bits/stdc++.h>
using namespace std;

// Function to calculate factorial using a loop
int factorialLoop(int n)
{
    int fact = 1; // Initialize factorial result to 1

    // If n is less than 2, return 1 (as 0! = 1 and 1! = 1)
    if (n < 2)
        return 1;

    // Loop to multiply numbers from n down to 2
    for (int i = n; i > 1; i--)
    {
        fact = fact * i; // Multiply 'fact' by each number in the loop
    }
    return fact; // Return the factorial result

    // Time Complexity: O(n) - The loop runs 'n' times
    // Space Complexity: O(1) - Constant space is used (only a few variables)
}

// Brute-force function to count trailing zeroes by calculating factorial first
int countZeroesBruteForce(int n)
{
    // Calculate factorial using the factorialLoop function
    int fact = factorialLoop(n);

    int c = 0; // Initialize counter for trailing zeroes

    // Divide the factorial by 10 until it is no longer divisible by 10
    while (fact % 10 == 0)
    {
        fact /= 10; // Remove one trailing zero
        c++;        // Increment the counter
    }

    return c;

    // Time Complexity: O(n) to compute the factorial + O(d) for removing trailing zeroes,
    // where 'd' is the number of digits in the factorial. 
    // The factorialLoop takes O(n) time to compute, and dividing by 10 takes O(d).
    // However, the factorial becomes extremely large, making this approach impractical.And Causing OverFlow
}

// Optimized function to count trailing zeroes without computing factorial
/**
 * Function to count trailing zeroes in factorial of a number.
 *
 * Trailing zeroes are produced by factors of 10. Since 10 is the product of
 * 2 and 5, we need to determine how many times 5 appears as a factor in the
 * factorial of a number n. The number of trailing zeroes is determined by
 * the number of 5's in the factorization of n!.
 *
 * Explanation:
 * 1. Every multiple of 5 contributes at least one factor of 5.
 *    For example, multiples of 5, 25, 125, etc., contribute factors of 5.
 *
 * 2. To count trailing zeroes:
 *    - Count how many multiples of 5 are there from 1 to n. This is given by
 *      n / 5.
 *    - Count how many multiples of 25 are there from 1 to n. These numbers
 *      contribute an extra factor of 5. This is given by n / 25.
 *    - Similarly, count multiples of 125, 625, etc., as these contribute
 *      more factors of 5.
 *
 * 3. The formula for counting the number of trailing zeroes is:
 *    Trailing Zeroes = n / 5 + n / 25 + n / 125 + n / 625 + ...
 *    We stop when n / 5^k is less than 1.
 *
 * Example:
 * To find the number of trailing zeroes in 100!:
 * - Multiples of 5: 100 / 5 = 20
 * - Multiples of 25: 100 / 25 = 4
 * - Multiples of 125: 100 / 125 = 0
 *
 * Total trailing zeroes = 20 + 4 = 24
 *
 * Thus, 100! has 24 trailing zeroes.
 */
int countZeroesOptimized(int n)
{   //Integer Division Give Floor Value
    int x = 5;  // Start with 5 (since every multiple of 5 contributes at least one 5)
    int c = 0;  // Initialize counter for trailing zeroes

    // Loop to count factors of 5, 25, 125, etc.
    while (floor(n / x) > 0)
    {
        c += floor(n / x); // Add the number of multiples of x (5, 25, 125, ...)
        x = x * 5;         // Move to the next power of 5
    }

    return c;

    // Time Complexity: O(log_5(n)) - Each iteration of the loop checks multiples of powers of 5,
    // meaning the loop runs approximately log_5(n) times. This is much more efficient than 
    // computing the entire factorial.
    // Space Complexity: O(1) - Constant space is used.
}

int main()
{
    int n = 100; // Example input: 100!
   
    // Optimized way to count trailing zeroes
    cout << "No Zero in " << n << ": " << countZeroesOptimized(n);
}
