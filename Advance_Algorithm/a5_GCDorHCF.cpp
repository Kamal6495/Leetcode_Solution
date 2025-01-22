#include <bits/stdc++.h>
using namespace std;

/*
The greatest common divisor (GCD) of two or more numbers is the greatest common factor
number that divides them exactly. It is also called the highest common factor (HCF).
*/

/**
 * Function to compute the greatest common divisor (GCD) of two numbers
 * using the brute force method (approach A).
 *
 * This method starts with the minimum of the two numbers and checks downwards
 * to find the largest number that divides both a and b.
 *
 * Time Complexity: O(min(a, b)) - The loop runs until the smallest of the two numbers.
 * Space Complexity: O(1) - Constant space is used since only a few variables are involved.
 */
int hcfBrute_A(int a, int b)
{
    int res = min(a, b); // Start with the minimum of a and b

    while (res > 0)
    {
        if (a % res == 0 && b % res == 0) // Check if res divides both a and b
            break;                        // Found the GCD
        res--;                            // Decrement res to check the next possible GCD
    }

    return res; // Return the GCD
}

/**
 * Function to compute the greatest common divisor (GCD) of two numbers
 * using the brute force method (approach B).
 *
 * This method iterates through all numbers from 1 to the minimum of a and b
 * to find the GCD by multiplying common divisors.
 *
 * Time Complexity: O(min(a, b)) - The loop runs until the smallest of the two numbers.
 * Space Complexity: O(1) - Constant space is used since only a few variables are involved.
 */
int hcfBrute_B(int a, int b)
{
    int res = 1; // Initialize result to 1

    // Loop through all numbers up to the minimum of a and b
    for (int i = 1; i <= min(a, b); i++)
    {
        // Check if i divides both a and b
        if (a % i == 0 && b % i == 0) 
        {
            res = i; // Update res to the current common divisor
        }
    }

    return res; // Return the GCD
}


/**
 * Function to compute the greatest common divisor (GCD) of two numbers
 * using the subtraction-based Euclidean algorithm.
 *
 * The algorithm uses the property:
 * gcd(a, b) = gcd(a - b, b) if a > b
 * gcd(a, b) = gcd(b - a, a) if b > a
 *
 * This process continues until a == b, at which point the GCD is a (or b).
 *
 *  * Definitions and Assumptions:
 * Let a and b be two positive integers. We denote the greatest common divisor of
 * a and b as gcd(a, b). By definition, gcd(a, b) is the largest integer d such that:
 *
 * d / a and d / b
 *
 * This means that d divides both a and b.
 *
 * We want to prove that:
 *
 * gcd(a, b) = gcd(a - b, b)
 *
 * Step 1: gcd(a, b) divides both a and b
 * Assume d = gcd(a, b). By definition, d divides both a and b:
 *
 * d / a and d / b
 *
 * This means there exist integers k1 and k2 such that:
 *
 * a = d * k1 and b = d * k2
 *
 * Step 2: d divides a - b
 * Now, consider a - b:
 *
 * a - b = d * k1 - d * k2 = d * (k1 - k2)
 *
 * Since d divides both a and b, it must also divide their difference a - b:
 *
 * d / (a - b)
 *
 * Thus, d / (a - b) and d / b.
 *
 * Step 3: gcd(a - b, b) divides both a - b and b
 * Let d' = gcd(a - b, b). By definition, d' divides both a - b and b:
 *
 * d' / (a - b) and d' / b
 *
 * Thus, d' also divides:
 *
 * a = (a - b) + b
 *
 * Since d' divides both a - b and b, it follows that d' divides a. Hence:
 *
 * d' / a and d' / b
 *
 * This means d' is a common divisor of a and b.
 *
 * Step 4: d = d'
 * From Step 2, we know that d is a divisor of both a - b and b. Therefore, d
 * is a common divisor of a - b and b, which means:
 *
 * d / gcd(a - b, b)
 *
 * Similarly, from Step 3, we know that d' is a common divisor of a and b, so:
 *
 * d' / gcd(a, b)
 *
 * Since both d and d' divide a and b, and they are both the greatest common divisor,
 * it follows that:
 *
 * d = d'
 *
 * Thus, we have shown that:
 *
 * gcd(a, b) = gcd(a - b, b)
 *
 * This completes the proof.
 *
 *
 * Time Complexity: O(max(a, b)) - In the worst case, the larger number is reduced
 * by the smaller one repeatedly, potentially requiring many subtractions.
 * Space Complexity: O(1) - Constant space is used since only a few variables are involved.
 */
int gcdEucledianSubtraction(int a, int b)
{
    // Continue the loop until a and b become equal
    while (a != b)
    {
        if (a > b)
        {
            a = a - b; // Replace a with a - b if a is greater
        }
        else
        {
            b = b - a; // Replace b with b - a if b is greater
        }
    }

    // When a equals b, the GCD is a (or b)
    return a;
}

/**
 * The property gcd(a, b) = gcd(b, a mod b) states that the greatest common divisor
 * of two numbers remains unchanged if the larger number is replaced by the remainder
 * of the division of the larger number by the smaller number. The proof is as follows:
 *
 * Definitions and Assumptions:
 * Let a and b be two positive integers. We denote the greatest common divisor of
 * a and b as gcd(a, b). By definition, gcd(a, b) is the largest integer d such that:
 *
 * d / a and d / b
 *
 * This means that d divides both a and b.
 *
 * We want to prove that:
 *
 * gcd(a, b) = gcd(b, a mod b)
 *
 * Step 1: gcd(a, b) divides both a and b
 * Assume d = gcd(a, b). By definition, d divides both a and b:
 *
 * d / a and d / b
 *
 * This means there exist integers k1 and k2 such that:
 *
 * a = d * k1 and b = d * k2
 *
 * Step 2: d divides a mod b
 * The expression a mod b gives the remainder when a is divided by b. By definition of
 * the modulo operation:
 *
 * a mod b = a - (b * (a / b))
 *
 * Since d divides both a and b, it must also divide any linear combination of them,
 * including a mod b:
 *
 * d / (a mod b)
 *
 * Thus, we have:
 *
 * d / (a mod b) and d / b
 *
 * Step 3: gcd(b, a mod b) divides both b and a mod b
 * Let d' = gcd(b, a mod b). By definition, d' divides both b and a mod b:
 *
 * d' / b and d' / (a mod b)
 *
 * From Step 2, we know that d divides a mod b. Thus, since d' divides a mod b and b,
 * it follows that:
 *
 * d' / a
 *
 * Therefore, d' is also a common divisor of a and b.
 *
 * Step 4: d = d'
 * From Step 2, we know that d is a divisor of both b and a mod b. Therefore, d is a
 * common divisor of b and a mod b, which means:
 *
 * d / gcd(b, a mod b)
 *
 * Similarly, from Step 3, we know that d' is a common divisor of a and b, so:
 *
 * d' / gcd(a, b)
 *
 * Since both d and d' divide a and b, and they are both the greatest common divisor,
 * it follows that:
 *
 * d = d'
 *
 * Thus, we have shown that:
 *
 * gcd(a, b) = gcd(b, a mod b)
 *
 * This completes the proof.
 */
int gcdEucledianModulo(int a, int b)
{
    // Continue the loop until b becomes 0
    while (b != 0)
    {
        int remainder = a % b; // Find the remainder of a divided by b
        a = b;                 // Set a to b
        b = remainder;         // Set b to the remainder
    }

    // When b becomes 0, a is the GCD
    return a;
}

int main()
{
    int a = 48;
    int b = 18;

    // Example: Computing the GCD using the subtraction-based Euclidean algorithm
        cout << "GCD of " << a << " and " << b << " using Brute Force A is: " << hcfBrute_A(a, b) << endl;
    cout << "GCD of " << a << " and " << b << " using Brute Force B is: " << hcfBrute_B(a, b) << endl;
    cout << "GCD of " << a << " and " << b << " using subtraction is: " << gcdEucledianSubtraction(a, b) << endl;
    cout << "GCD of " << a << " and " << b << " using modulo is: " << gcdEucledianModulo(a, b) << endl;

    return 0;
}
