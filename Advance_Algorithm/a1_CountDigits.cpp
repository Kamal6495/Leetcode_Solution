#include <bits/stdc++.h>
using namespace std;

// Function to count the number of digits in a number
int countDigits(int n)
{
    // Take the absolute value of the number to handle negative inputs
    int dup = abs(n), count = 0;

    // Loop to repeatedly divide the number by 10 and count the digits
    while (dup > 0)
    {
        dup /= 10;  // Remove the last digit of the number
        count++;    // Increment the count for each digit removed
    }

    return count;   // Return the total count of digits
}

int main()
{
    int x;  // Variable to store user input
    cout << "Enter Number: ";  // Prompt the user for input
    cin >> x;  // Read the input number

    // Output the number of digits in the entered number
    cout << "No of Digits: " << countDigits(x);
}

// Time Complexity: Θ(log₁₀(n)), where n is the absolute value of the input number
