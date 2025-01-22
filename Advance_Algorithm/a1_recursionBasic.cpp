

#include <bits/stdc++.h>
using namespace std;
int cnt1 = 1;
void fun()
{
    if (cnt1 == 4)
        return;

    cout << cnt1 << endl;
    cnt1++;
    fun();
}

int main()
{
    fun();
    return 0;
}

/*
//Infinite Recursion
#include<bits/stdc++.h>
using namespace std;

void fun(){

    cout<<1<<endl;
    fun();
}

int main(){
    fun();
}*/
