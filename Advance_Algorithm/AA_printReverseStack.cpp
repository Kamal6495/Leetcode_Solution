#include <bits/stdc++.h>
using namespace std;

void printStRev(stack<int> s) {
 
    if (s.empty())
        return;

    int p = s.top();
    s.pop();

    printStRev(s);

    cout << p << endl;
    s.push(p);
}

int main()
{

    int k;
    stack<int> s;
    while (k != 0)
    {
        cin >> k;
        s.push(k);
    }

    printStRev(s);
}