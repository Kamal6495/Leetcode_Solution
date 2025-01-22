//Print Linearly 1 to N
#include<bits/stdc++.h>
using namespace std;

void fun(int x,int n){
if(x>n) return;
cout<<x<<endl;
fun(x+1,n);

}



int main(){

    int n=10;
 fun(1,n);
}