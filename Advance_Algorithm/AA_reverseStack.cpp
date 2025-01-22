#include <bits/stdc++.h>
using namespace std;

void insertReverseStack(stack<int>& s, int ele) {
    if (s.empty()) {
        s.push(ele);
        return;
    }

    int topElement = s.top();
    s.pop();
    insertReverseStack(s, ele);
    s.push(topElement);
}

stack<int> reverseStack(stack<int> s) {
    if (s.empty()) {
        return s;
    }

    int element = s.top();
    s.pop();
    stack<int> reversed = reverseStack(s);
    insertReverseStack(reversed, element);
    return reversed;
}

void printStack(stack<int> s) {
    while (!s.empty()) {
        cout << s.top() << endl;
        s.pop();
    }
}

int main() {
    int k;
    stack<int> s;

    //cout << "Enter elements (enter 0 to stop):" << endl;
    while (true) {
        cin >> k;
        if (k == 0) break;
        s.push(k);
    }

    cout << "Original stack elements:" << endl;
    printStack(s);

    stack<int> reversedStack = reverseStack(s);

    cout << "Reversed stack elements:" << endl;
    printStack(reversedStack);

    return 0;
}
