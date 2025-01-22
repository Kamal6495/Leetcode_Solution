#include <bits/stdc++.h>
using namespace std;

/**
 * Function: isPrimeMoreEfficient
 * - Checks if a number is prime using an efficient method.
 *
 * Explanation:
 * - For small values like 1, 2, and 3, we handle them directly.
 * - We then eliminate multiples of 2 and 3.
 * - After that, we only check divisibility for numbers of the form 6k ± 1, which optimizes
 *   the checking by skipping numbers divisible by 2 and 3.
 *
 * Time Complexity: O(sqrt(n))
 * - We only need to check divisors up to sqrt(n) to determine if n is prime.
 * Space Complexity: O(1)
 */
bool isPrimeMoreEfficient(int n)
{
    if (n == 1)
        return false;

    if (n == 2 || n == 3)
        return true;

    // Eliminate multiples of 2 and 3 early
    if (n % 2 == 0 || n % 3 == 0)
        return false;

    // Check divisibility for numbers of the form 6k ± 1
    for (int i = 5; i * i <= n; i += 6)
    {
        if (n % i == 0 || n % (i + 2) == 0)
            return false;
    }
    return true;
}

/**
 * Function: primeNumbersListBrute
 * - Prints all prime numbers from 1 to n using a brute force method.
 *
 * Explanation:
 * - The function iterates through every number from 1 to n and checks if each number
 *   is prime using the `isPrimeMoreEfficient` function.
 *
 * Time Complexity: O(n * sqrt(n))
 * - For each number from 1 to n, the isPrimeMoreEfficient function is called,
 *   which runs in O(sqrt(i)).
 * Space Complexity: O(1)
 */
void primeNumbersListBrute(int n)
{
    for (int i = 1; i <= n; i++)
    {
        // Check if the current number is prime
        if (isPrimeMoreEfficient(i))
            cout << i << " ";
    }

    cout << endl;
}

/**
 * Function: primeNumberListSieveOfEratosthenes
 * - Prints all prime numbers up to n using the Sieve of Eratosthenes algorithm.
 *
 * Explanation:
 * - Initializes a boolean vector `isPrime` of size n+1 to keep track of whether each number
 *   is prime. Initially, all numbers are considered prime.
 * - It iterates through numbers starting from 2. For each prime number, it marks all its multiples
 *   as non-prime by setting them to `false`.
 *
 * Time Complexity: O(n log log n)
 * - For each prime number i, we mark all its multiples, which results in the time complexity
 *   O(n log log n).
 * Space Complexity: O(n)
 * - A boolean vector of size n+1 is used to store whether a number is prime.
 */
void primeNumberListSieveOfEratosthenes(int n)
{
    vector<bool> isPrime(n + 1, true); // Boolean vector to store prime information

    // Iterate over numbers up to sqrt(n) and mark their multiples
    for (int i = 2; i * i <= n; i++)
    {
        if (isPrime[i])
        {
            // Mark multiples of i as false
            for (int j = 2 * i; j <= n; j += i)
            {
                isPrime[j] = false;
            }
        }
    }

    // Print all numbers that are still marked as prime
    for (int i = 2; i <= n; i++)
    {
        if (isPrime[i])
            cout << i << " ";
    }

    cout << endl;
}

/**
 * Function: primeNumberListSieveOfEratosthenesOptimized
 * - Optimized version of the Sieve of Eratosthenes algorithm to find primes up to n.
 *
 * Explanation:
 * - The optimization is in the inner loop where we start marking multiples of i
 *   from `i * i` instead of `2 * i` because all smaller multiples (like `i * 2`, `i * 3`)
 *   would have already been marked by smaller prime factors.
 *
 * Time Complexity: O(n log log n)
 * - The optimized sieve runs in O(n log log n), similar to the unoptimized version.
 * Space Complexity: O(n)
 */
void primeNumberListSieveOfEratosthenesOptimized(int n)
{
    vector<bool> isPrime(n + 1, true); // Boolean vector to store prime information

    // Iterate over numbers up to sqrt(n) and mark their multiples
    for (int i = 2; i * i <= n; i++)
    {
        if (isPrime[i])
        {
            // Mark multiples of i starting from i * i
            for (int j = i * i; j <= n; j += i)
            {
                isPrime[j] = false; // Mark multiples of i as not prime
            }
        }
    }

    // Print all numbers that are still marked as prime
    for (int i = 2; i <= n; i++)
    {
        if (isPrime[i])
            cout << i << " ";
    }

    cout << endl;
}

/**
 * Function: primeListSieveShorterImplementation
 * - A shorter and compact implementation of the Sieve of Eratosthenes algorithm.
 *
 * Explanation:
 * - This function prints prime numbers up to n. It uses the `isPrimeMoreEfficient` function to
 *   check whether a number is prime, then marks its multiples starting from `i * i`.
 * - It's a shorter implementation but follows the same sieve logic.
 *
 * Time Complexity: O(n log log n)
 * Space Complexity: O(n)
 */
void primeListSieveShorterImplementation(int n)
{
    vector<bool> isPrime(n + 1, true);

    for (int i = 2; i <= n; i++)
    {
        if (isPrimeMoreEfficient(i))
        {
            cout << i << " ";
            for (int j = i * i; j <= n; j += i)
                isPrime[j] = false;
        }
    }

    cout << endl;
}

int main()
{
    // Using brute force method to find primes up to 56
    primeNumbersListBrute(56);

    // Using Sieve of Eratosthenes to find primes up to 56
    primeNumberListSieveOfEratosthenes(56);

    // Using optimized Sieve of Eratosthenes to find primes up to 56
    primeNumberListSieveOfEratosthenesOptimized(56);

    // Using shorter implementation of Sieve of Eratosthenes to find primes up to 56
    primeListSieveShorterImplementation(56);
}
