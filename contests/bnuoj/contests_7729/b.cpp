/*************************************************************************
	> File Name: 2.cpp
	> Author: wxc575843
	> Mail:wxc575843@163.com 
	> Created Time: 五  4/ 8 17:54:07 2016
 ************************************************************************/

#include<iostream>
#include<cmath>
#include<cstdio>
using namespace std;

void solve(){
    double a,b;
    unsigned long long int n;
    cin>>a>>b>>n;
    long long int A,B;
    n--;
    A=n/2;
    double result;
    if(n%2==0){
        result=log10(a)+log10(3)*A;
    }
    else{
        result=log10(b)+A*log10(3);
    }
    printf("%.10lf\n",result);
}

int main(){
    int n;
    cin>>n;
    while(n--){
        solve();
    }
    return 0;
}
