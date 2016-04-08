/*************************************************************************
	> File Name: 1.cpp
	> Author: wxc575843
	> Mail:wxc575843@163.com 
	> Created Time: 五  4/ 8 17:31:55 2016
 ************************************************************************/
#include<iostream>
using namespace std;
int main(){
    int M[101],K[100];
    int num;
    cin >> num;
    long long int sum=0;
    for(int i=0;i<num;i++){
        cin>>K[i]>>M[i];
        sum+=K[i]*M[i];
    }
    sum=(sum+1)*6;
    int level_low=1,level_high=100;
    while(level_low<level_high-1){
        int middle=(level_low+level_high)/2;
        long long int times=middle*(middle+1)*(2*middle+1);
        if(times<=sum) level_low=middle;
        else level_high=middle;
    }
    long long int tmp=level_high*(level_high+1)*(2*level_high+1);
    int result=0;
    if(tmp<=sum) result=level_high;
    else result=level_low;
    if(result>=100) result=99;
    if(result==0) result=1;
    cout<<"Team Liserious' rank is "<<result<<endl;
    return 0;
}
