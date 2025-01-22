#include <bits/stdc++.h>
using namespace std;

// Function to check if a number is a palindrome
// The idea is to reverse the number and compare it with the original
bool isPalindrome(int n)
{
    int rev = 0, org = n; // 'rev' will store the reversed number, 'org' holds the original value of n
    
    // Loop to reverse the number
    while (org > 0)
    {
        rev = rev * 10 + org % 10; // Add the last digit of 'org' to 'rev'
        org /= 10;                 // Remove the last digit from 'org'
    }

    // Return true if the reversed number is equal to the original number
    return (rev == n) ? true : false;
}

int main()
{
    int x = 1221; // Example number to check if it's a palindrome
    // Output whether the number is a palindrome or not
    cout << "Number is " << (isPalindrome(x) ? "" : "Not ") << "Palindrome"; 
}

// Time Complexity: Θ(d), where 'd' is the number of digits in the input number 'n'.
// Since reversing the number requires iterating through each digit, the time complexity is proportional to the number of digits.
// Alternatively, this can be expressed as Θ(log₁₀(n)), since 'd' is approximately log₁₀(n) for a number with 'n' digits.
