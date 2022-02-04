
#include<bits/stdc++.h>
using namespace std;

int size = 5;
char arr[5];
int top = -1;

void push(char x);
char topEle();
char pop();
void printStack();

int main(){
	
	int s = 100;
	char exp[s];
	gets(exp);

	for(int i=0; i < s && exp[i] != '\0'; i++){
		char ch = exp[i];
		if(ch == '(' || ch == '{' || ch == '[') push(ch);
		else if(ch == ')' || ch == '}' || ch == ']'){
			if(top == -1){
				cout<<"Invalid";
				return 0;
			}
			bool flag = true;
			if(topEle() == '(' && ch!=')') flag = false;
			else if(topEle() == '[' && ch!=']') flag = false;
			else if(topEle() == '{' && ch!='}') flag = false;
			if(!flag){
				cout<<"Invalid";
				return 0;
			}
			else pop();
		}
	}
	if(top == -1) cout<<"Valid";
	else cout<<"Invalid";

}

void push(char x){
	if( top == size-1){
		return;
	}
	arr[++top] = x;
}
char topEle(){
	if(top == -1){
		return -1;
	}
	return arr[top];
}
char pop(){
	if(top == -1){
		return 'x';
	}
	return arr[top--];
}
void printStack(){
	for(int i=0;i<=top;i++) cout<<arr[i]<<" ";
	cout<<endl;
}
