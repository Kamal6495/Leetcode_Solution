#include <bits/stdc++.h>
using namespace std;

// More efficient function to check if a number is prime
bool isPrimeMoreEfficient(int n)
{
    if (n == 1)
        return false;

    if (n == 2 || n == 3)
        return true;

    // Eliminate multiples of 2 and 3 early
    if (n % 2 == 0 || n % 3 == 0)
        return false;

    // Check divisibility for numbers of the form 6k ± 1, starting from 5
    for (int i = 5; i * i <= n; i += 6)
    {
        if (n % i == 0 || n % (i + 2) == 0)
            return false;
    }
    return true;
}
// Time Complexity: O(sqrt(n)) for primality checking.


// Brute-force approach to find prime factors
void primeFactorsBrute(int n)
{
    if (n <= 1)
        return;

    // Check every number from 2 to n if it's a prime factor
    for (int i = 2; i <= n; i++)
    {
        // Check if i is prime
        if (isPrimeMoreEfficient(i))
        {
            int x = i;

            // If i divides n, keep dividing n by powers of i
            while (n % x == 0)
            {
                cout << i << " ";
                x *= i; // Move to the next power of i
            }
        }
    }
}
// Time Complexity: O(n * sqrt(n))
// Reason: For each number from 2 to n, we check if it's prime, which takes O(sqrt(n)), and then check how many times it divides n.


// Efficient approach to find prime factors
void primeFactorsEfficient(int n)
{
    if (n <= 1)
        return;

    // Check divisibility by every number i starting from 2
    for (int i = 2; i <= n;)
    {
        // While i divides n, print i and divide n
        if (n % i == 0)
        {
            cout << i << " ";
            n /= i; // Reduce n by the factor
        }
        else
            i++; // Move to the next number
    }
}
// Time Complexity: O(n)
// Reason: The loop runs at most n times, checking divisibility for each number.


// More efficient approach to find prime factors
void primeFactorsMoreEfficient(int n)
{
    if (n <= 1)
        return;

    // Check divisibility for numbers starting from 2
    for (int i = 2; i * i <= n; i++)
    {
        // While i divides n, print i and divide n
        while (n % i == 0)
        {
            cout << i << " ";
            n /= i; // Reduce n by the factor
        }
    }

    // If n is still greater than 1, it must be a prime factor
    if (n > 1)
        cout << n;
}
// Time Complexity: O(sqrt(n))
// Reason: We only check divisibility up to sqrt(n), which reduces the number of iterations compared to the brute-force method.


// Most efficient prime factorization method
void primeFactorsMuchEfficient(int n)
{
    if (n <= 1)
        return;

    // Check for the factor of 2
    while (n % 2 == 0)
    {
        cout << 2 << " ";
        n /= 2; // Reduce n by the factor
    }

    // Check for the factor of 3
    while (n % 3 == 0)
    {
        cout << 3 << " ";
        n /= 3; // Reduce n by the factor
    }

    // Check for factors of the form 6k ± 1
    for (int i = 5; i * i <= n; i += 6)
    {
        // While i divides n, print i and divide n
        while (n % i == 0)
        {
            cout << i << " ";
            n /= i; // Reduce n by the factor
        }

        // While (i + 2) divides n, print (i + 2) and divide n
        while (n % (i + 2) == 0)
        {
            cout << (i + 2) << " ";
            n /= (i + 2); // Reduce n by the factor
        }
    }

    // If n is still greater than 3, it must be a prime factor
    if (n > 3)
        cout << n;
}
// Time Complexity: O(sqrt(n))
// Reason: This function handles the small factors (2 and 3) separately, then checks up to sqrt(n) for larger factors, optimizing the process.

int main()
{
    // Brute-force prime factorization of 112
    primeFactorsBrute(112); 
    cout << endl;

    // Efficient prime factorization of 212
    primeFactorsEfficient(212);
    cout << endl;

    // More efficient prime factorization of 312
    primeFactorsMoreEfficient(312);
    cout << endl;

    // Most efficient prime factorization of 412
    primeFactorsMuchEfficient(412);
    cout << endl;

    return 0;
}
