//Print Name 5 Times
#include <bits/stdc++.h>
using namespace std;
int cnt1 = 0;
void fun()
{
    if (cnt1 == 5)
        return;

    cout << "Kamal" <<" ->FUN1"<< endl;
    cnt1++;
    fun();
}

void fun2(int i,int n){

if(i>n)
return;
cout<<"Kamal"<<" ->FUN2"<<endl;

fun2(i+1,n);

}

int main()
{fun();
    fun2(1,5);
    return 0; 
}