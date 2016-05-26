//
//  2.cpp
//  
//
//  Created by Wang Bill on 16/5/3.
//
//

#include "2.hpp"
#include <iostream>

class minStack{
    struct minStackNode{
        int data;
        int min;
        minStackNode *next;
    };
    minStackNode *sTop;
public:
    int min() const;
    void push(int &x);
    void pop();
};

int minStack::min() const{
    if (sTop==nullptr) {
        return 0xFFFFFFFF;
    }
    return sTop->min;
}

void minStack::push(int &x){
    minStackNode *tmp=new minStackNode();
    tmp->data=x;
    tmp->next=sTop;
    tmp->min=(tmp->data<sTop->min)?tmp->data:sTop->min;
}

void minStack::pop(){
    minStackNode *tmp=sTop;
    sTop=sTop->next;
    delete tmp;
}

int main(){
    
    return 0;
}