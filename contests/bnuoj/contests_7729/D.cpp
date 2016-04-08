/*************************************************************************
	> File Name: D.cpp
	> Author: wxc575843
	> Mail:wxc575843@163.com 
	> Created Time: 五  4/ 8 19:36:04 2016
 ************************************************************************/

#include<iostream>
#include<cmath>
#include<cstdio>
using namespace std;

const double PI=3.14159265358;

struct node{
    double x,y,d;
};

int main(){
    int t;
    cin>>t;
    while(t--){
        int n;
        cin>>n;
        node star[2];
        node mu,bh3;
        node tmp;
        star[0].d=star[1].d=1000;
        for(int i=0;i<n;i++){
            cin>>tmp.x>>tmp.y>>tmp.d;
            if(tmp.d<star[0].d){
                star[1].x=star[0].x;
                star[1].y=star[0].y;
                star[1].d=star[0].d;
                star[0].x=tmp.x;
                star[0].y=tmp.y;
                star[0].d=tmp.d;
            }
            else if(tmp.d<star[1].d){
                star[1].x=tmp.x;
                star[1].y=tmp.y;
                star[1].d=tmp.d;
            }
        }
        cin>>mu.x>>mu.y>>bh3.x>>bh3.y;
        double moyes,mono;
        moyes=(star[0].x-star[1].x)*(star[0].x-star[1].x)+(star[0].y-star[1].y)*(star[0].y-star[1].y);
        moyes=sqrt(moyes);

        mono=(mu.x-bh3.x)*(mu.x-bh3.x)+(mu.y-bh3.y)*(mu.y-bh3.y);
        mono=sqrt(mono);

        double ab=(mu.x-bh3.x)*(star[0].x-star[1].x)+(mu.y-bh3.y)*(star[0].y-star[1].y);

        double result=acos(ab/(moyes*mono));
        result=result*180/PI;
        if(result<0) result=result+360;
        printf("%.3lf\n",result);
    }
    return 0;
}
