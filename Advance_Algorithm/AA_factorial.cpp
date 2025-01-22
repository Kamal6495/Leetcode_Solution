//optimized using tail recursion

/*Tail Recursion: The recursive call is the last operation in the function 
(auxFact(k - 1, k * i)), making it optimized for compilers that support tail-call optimization. This reduces the risk of stack overflow for large values of k.*/
#include <bits/stdc++.h>
using namespace std;

int auxFact(int k,int i){

    if(k==1)
    return i;

    return auxFact(k-1,k*i);
}


int fact(int k){

    return auxFact(k,1);
}




int main(){

    int k;
    while(k>0)
   { cin>>k;

    cout<<fact(k)<<endl;
   }
}