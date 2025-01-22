#include <bits/stdc++.h>
using namespace std;

// Function to check if a number is prime using brute force method
bool isPrimeBrute(int n)
{
    if (n == 1)
        return false;

    // Check divisibility by every number from 2 to n-1
    for (int i = 2; i < n; i++)
    {
        if (n % i == 0)
            return false;
    }
    return true;
} 
// Time Complexity: O(n) because we iterate from 2 to n-1.

// Optimized function to check if a number is prime by only checking up to sqrt(n)
bool isPrimeEfficient(int n)
{
    if (n == 1)
        return false;

    // Check divisibility only up to sqrt(n)
    for (int i = 2; i * i <= n; i++)
    {
        if (n % i == 0)
            return false;
    }
    return true;
} 
// Time Complexity: O(sqrt(n)) because we only check divisibility up to sqrt(n).

// More efficient function to check if a number is prime
// Uses 6k ± 1 rule to reduce unnecessary checks
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
        if (n % i == 0 || n % (i + 2) == 0) // for twin prime number example (5,7),(11,13), etc.
            return false;
    }
    return true;
}
// Time Complexity: O(sqrt(n)) but more efficient than the previous method
// because it skips multiples of 2 and 3, reducing the number of checks.

int main()
{
    int n = 457;

    // Test the brute force prime checking function
    cout << n << (isPrimeBrute(n) ? " is Prime" : " is Not prime") << endl;

    // Test the efficient sqrt(n) prime checking function
    cout << n << (isPrimeEfficient(n) ? " is Prime" : " is Not prime") << endl;

    // Test the most efficient prime checking function
    cout << n << (isPrimeMoreEfficient(n) ? " is Prime" : " is Not prime") << endl;
}
