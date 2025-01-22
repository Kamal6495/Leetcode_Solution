#include <bits/stdc++.h>
using namespace std;

/**
 * Function to print all divisors of a number using a brute force approach.
 * 
 * The function iterates from 1 to n and checks if each number divides n exactly.
 * If it does, that number is a divisor.
 * 
 * Time Complexity: O(n)
 * - For every number i from 1 to n, we check if it divides n (n % i == 0).
 * Space Complexity: O(1)
 * - No extra space is used except for the loop variable i.
 */
void divisorsBrute(int n)
{
    for (int i = 1; i <= n; i++) // Loop through all numbers from 1 to n
    {
        if (n % i == 0) // Check if i is a divisor of n
            cout << i << " "; // If so, print it
    }
    cout << endl;
}

/**
 * Function to print all divisors of a number in an unordered way using an efficient approach.
 * 
 * The divisors occur in pairs. For a divisor i less than or equal to sqrt(n),
 * the corresponding pair divisor is n / i. This function uses that property to
 * reduce the number of checks.
 * 
 * Time Complexity: O(sqrt(n))
 * - Only iterates up to sqrt(n) and for each divisor, prints its pair.
 * Space Complexity: O(1)
 */
void divisorefficientUnordered(int n)
{
    for (int i = 1; i * i <= n; i++) // Loop up to sqrt(n)
    {
        if (n % i == 0) // If i is a divisor
        {
            cout << i << " "; // Print the divisor i
            if (i != (n / i)) // Avoid printing duplicate divisors for perfect squares
                cout << (n / i) << " "; // Print the corresponding paired divisor n / i
        }
    }
    cout << endl;
}

/**
 * Function to print all divisors of a number in an ordered way using an efficient approach.
 * 
 * The function is divided into two parts:
 * 1. First loop: Prints divisors in the range [1, sqrt(n)].
 * 2. Second loop: Prints divisors greater than sqrt(n) in reverse order, 
 *    ensuring they are printed in increasing order.
 * 
 * Time Complexity: O(sqrt(n))
 * - Two loops both running up to sqrt(n), making it efficient.
 * Space Complexity: O(1)
 */
void divisorEfficientOrdered(int n)
{
    int i;
    // First loop: Print divisors from 1 to sqrt(n)
    for (i = 1; i * i <= n; i++) // Loop up to sqrt(n)
    {
        if (n % i == 0) // If i is a divisor
            cout << i << " "; // Print the divisor i
    }

    // Second loop: Print divisors greater than sqrt(n) in reverse order
    for (i = i - 1; i >= 1; i--) // Loop down from sqrt(n) to 1
    {
        if (n % i == 0) // If i is a divisor
            cout << (n / i) << " "; // Print the corresponding paired divisor n / i
    }

    cout << endl;
}

int main()
{
    divisorsBrute(156);           // Brute force method for divisors of 156
    divisorefficientUnordered(268); // Efficient unordered divisors of 268
    divisorEfficientOrdered(568);  // Efficient ordered divisors of 568

    return 0;
}
