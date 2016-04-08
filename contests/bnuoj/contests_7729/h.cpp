/*************************************************************************
	> File Name: h.cpp
	> Author: wxc575843
	> Mail:wxc575843@163.com 
	> Created Time: 五  4/ 8 21:06:06 2016
 ************************************************************************/

#include<iostream>
#include<cmath>
#include<cstdio>
using namespace std;

int N=32;
double dp[32];

void init(){
    dp[1]=0.67;
    for(int i=2;i<N;i++){
        dp[i]=dp[i-1]/3+2.0/3*(dp[i-1]+pow(2,i-1));
    }
}

void solve(){
    int n;
    cin>>n;
    printf("%.2lf\n",dp[n]);
}

int main(){
    int num;
    init();
    cin>>num;
    while(num--){
        solve();
    }
    return 0;
}
