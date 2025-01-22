// Print N to 1

#include <bits/stdc++.h>
using namespace std;

void fun(int n)
{
    if (n <  1)
        return;
    cout << n << endl;
    fun(n - 1);
}

int main()
{

    int n = 10;
    fun(n);
}