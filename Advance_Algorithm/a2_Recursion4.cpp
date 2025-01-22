// Print 1 to N using backtrack recursion
#include <bits/stdc++.h>
using namespace std;

void fun(int x, int n)
{
    if (x < 1)
        return;
    fun(x - 1, n);
    cout << x << endl;
}

int main()
{

    fun(10, 10);
    return 0;
}