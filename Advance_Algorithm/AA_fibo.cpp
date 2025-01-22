#include <bits/stdc++.h>
using namespace std;

int aux_fibo(int a, int b, int n)
{
    if (n == 2)
        return b;

    else
        return aux_fibo(b, a + b, n - 1);
}

int fibo(int n)
{

    if (n == 1)
        return 0;
    else if (n == 2)
        return 1;
    else
        return aux_fibo(0, 1, n);
}

int main()
{

    int k;
    while (k > 0)
    {
        cin >> k;

        cout << fibo(k) << endl;
    }
}

/*
*#include <bits/stdc++.h>
using namespace std;

// Tail-recursive auxiliary function for Fibonacci
int aux_fibo(int a, int b, int n) {
    // Base case: When n becomes 2, return the second Fibonacci number (b)
    if (n == 2)
        return b;

    // Tail-recursive call: Update a to b and b to a + b, and decrement n
    return aux_fibo(b, a + b, n - 1);
}

// Main Fibonacci function
int fibo(int n) {
    // Handle base cases for Fibonacci sequence
    if (n == 1)
        return 0; // The first Fibonacci number
    else if (n == 2)
        return 1; // The second Fibonacci number

    // Call the tail-recursive helper function for n > 2
    return aux_fibo(0, 1, n);
}

int main() {
    int k;

    cout << "Enter positive integers to compute Fibonacci numbers (enter 0 or negative to exit):" << endl;

    // Loop to continuously accept input until a non-positive value is entered
    while (true) {
        cin >> k;

        if (k <= 0) // Exit condition
            break;

        // Compute and output the Fibonacci number
        cout << "Fibonacci number at

*/