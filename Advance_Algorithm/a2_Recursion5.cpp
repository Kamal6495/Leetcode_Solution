//Print N to 1 using backtrack recursion

#include <bits/stdc++.h>
using namespace std;

void fun(int x, int n)
{
    if (x > n)
        return;
    fun(x + 1, n);
    cout << x << endl;
}

int main()
{

    fun(1, 10);
    return 0;
}