#include <bits/stdc++.h>
using namespace std;

// Function to calculate factorial using a loop (iterative approach)
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

// Function to calculate factorial using recursion
int factorialRecursion(int n)
{
    // Base case: If n is 0, return 1 (as 0! = 1)
    if (n == 0)
        return 1;

    // Recursive case: Multiply 'n' by the factorial of (n-1)
    return n * factorialRecursion(n - 1);

    // Time Complexity: O(n) - Recursive calls occur 'n' times
    // Space Complexity: O(n) - Space required for the recursive call stack is proportional to 'n'
}

// Function to calculate factorial using Dynamic Programming (not implemented yet)
int factorialDynamicProgramming(int n)
{
    int fact = 1; // Placeholder result, dynamic programming not implemented yet
    return fact;
}

int main()
{
    int n = 12; // Example input: calculate the factorial of 12

    // Output the factorial of 12 using the iterative loop method
    cout << "Factorial of 12: " << factorialLoop(n);
}
