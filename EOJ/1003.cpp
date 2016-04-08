/*************************************************************************
	> File Name: 1003.cpp
	> Author:
	> Mail:
	> Created Time: 三  3/ 9 19:53:22 2016
 ************************************************************************/

#include<iostream>
#include<vector>
#include<stack>
using namespace std;

int num;

class formulaBool{
public:
    string middleFormula;
    vector<char> v_behindFormula;
    stack<char> s_symbol;
    stack<char> s_cmpt;
    void trans();
    void middle2behind();
    void compute();
    void output();
    bool compare(char input, char top);
};

void formulaBool::trans(){
    string tmp="";
    int len=middleFormula.length();
    for (int i=0; i<len; i++) {
        if(middleFormula[i]!=' ') tmp+=middleFormula[i];
    }
    len=tmp.length();
    string tmp2="";
    for (int i=0; i<len; i++) {
        if ((tmp[i]==tmp[i+1])&&(tmp[i]=='!')) {
            i++;
            continue;
        }
        tmp2+=tmp[i];
    }
    middleFormula=tmp2;
    //    cout << middleFormula<<endl;
}

bool formulaBool::compare(char input, char top){
    if(input=='(') return false;
    if(input==')') return true;
    if(input=='|'&&top!='(') return true;
    else if(input=='|') return false;
    if(input=='&'&&(top=='('||top=='|')) return false;
    else if(input=='&') return true;
    if(input=='!'&&top!='!') return false;
    else if(input=='!') return true;
    return true;
}

void formulaBool::compute(){
    int len=v_behindFormula.size();
    for (int i=0; i<len; i++) {
        if(v_behindFormula[i]=='V'||v_behindFormula[i]=='F'){
            s_cmpt.push(v_behindFormula[i]);
        }
        else{
            if(v_behindFormula[i]=='!'){
                char tmp=s_cmpt.top();
                s_cmpt.pop();
                if(tmp=='V') tmp='F';
                else tmp='V';
                s_cmpt.push(tmp);
            }
            if (v_behindFormula[i]=='&') {
                char tmp1=s_cmpt.top();
                s_cmpt.pop();
                char tmp2=s_cmpt.top();
                s_cmpt.pop();
                if(tmp1=='V'&&tmp2=='V') tmp1='V';
                else tmp1='F';
                s_cmpt.push(tmp1);
            }
            if(v_behindFormula[i]=='|'){
                char tmp1=s_cmpt.top();
                s_cmpt.pop();
                char tmp2=s_cmpt.top();
                s_cmpt.pop();
                if(tmp1=='F'&&tmp2=='F') tmp1='F';
                else tmp1='V';
                s_cmpt.push(tmp1);
            }
        }
    }
}

void formulaBool::middle2behind(){
    int len = middleFormula.length();
    for(int i=0;i<len;i++){
        if(middleFormula[i]=='V'||middleFormula[i]=='F'){
            v_behindFormula.push_back(middleFormula[i]);
        }
        else{
            if(s_symbol.empty()) s_symbol.push(middleFormula[i]);
            else{
                if(!this->compare(middleFormula[i],s_symbol.top())){
                    s_symbol.push(middleFormula[i]);
                }
                else{
                    if(middleFormula[i]==')'){
                        while(s_symbol.top()!='('){
                            char tmp=s_symbol.top();
                            v_behindFormula.push_back(tmp);
                            //                            cout << tmp <<endl;
                            s_symbol.pop();
                        }
                        //                        cout << s_symbol.top() <<endl;
                        s_symbol.pop();
                    }
                    else{
                        while(!s_symbol.empty()&&compare(middleFormula[i],s_symbol.top())){
                            char tmp=s_symbol.top();
                            v_behindFormula.push_back(tmp);
                            s_symbol.pop();
                        }
                        s_symbol.push(middleFormula[i]);
                    }
                    
                }
            }
        }
    }
    while (!s_symbol.empty()) {
        char tmp=s_symbol.top();
        v_behindFormula.push_back(tmp);
        s_symbol.pop();
    }
}

void formulaBool::output(){
    //    for(int i=0;i<v_behindFormula.size();i++){
    //        cout<<v_behindFormula[i];
    //    }
    char tmp=s_cmpt.top();
    //    cout << endl;
    cout<<"Expression "<<num+1<<": " << tmp<<endl;
    num++;
}

void solve(char *inputFormula){
    formulaBool myFormula;
    myFormula.middleFormula=inputFormula;
    myFormula.trans();
    myFormula.middle2behind();
    myFormula.compute();
    myFormula.output();
}

int main(){
    char inputFormula[6000];
    while(cin.getline(inputFormula,6000)){
        solve(inputFormula);
    }
    return 0;
}
