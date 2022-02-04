
#include<bits/stdc++.h>
using namespace std;

int max_size = 100;
char arr[100];
int top = -1;

void push(char x);
char topEle();
char pop();
void printStack();
int length(char ch[]);

int main(){
	
	int s = 100;
	char exp[s];
	gets(exp);
	int n = length(exp);
	for(int i=0; i<n/2;i++){
		push(exp[i]);
	}
	if(n%2 != 0) push(exp[n/2]);
	for(int i=n/2;i<n;i++){
		if(pop() != exp[i]){
			cout<<"Not Palindrome";
			return 0;
		}
	}
	cout<<"Palindrome";
	return 0;
}

void push(char x){
	if( top == max_size-1){
		cout<<"Stack full"<<endl;
		return;
	}
	arr[++top] = x;
}
char topEle(){
	if(top == -1){
		cout<<"Stack empty"<<endl;
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
int length(char ch[]){
	int size = 0;
	for(int i = 0; i < max_size && ch[i] != '\0'; i++){
		size++;
	}
	return size;
}
