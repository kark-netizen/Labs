#include<bits/stdc++.h>
using namespace std;

#define size 100
char arr[size];
int top = -1;

void push(char x);
char peek();
char pop();
void printStack();

void infixToPostfix(char exp[],char s[], int n);
void infixToPrefix(char exp[],char s[] , int n);
void print(char s[]);
int precedence(char c);
void reverse(char s[],int n);
int length(char ch[]);

int main(){
	char exp[100];
	gets(exp);
	int n = length(exp);
	char postfix[100];
	infixToPostfix(exp, postfix , n);
	cout<<"Postfix: ";
	print(postfix);
	char prefix[100];
	infixToPrefix(exp, prefix , n);
	cout<<"Prefix: ";
	print(prefix);
}
void infixToPostfix(char exp[], char s[],int n){
	int k = 0;
	for(int i = 0; i < n; i++){
		if(exp[i] != '+' && exp[i] != '-' && exp[i] != '*' && exp[i] != '/' ){
			s[k++] = exp[i];
		}
		else{
			if(top == -1 || precedence(exp[i]) > precedence(peek())) 
				push(exp[i]);
			else{
				while(true){
					if( top == -1 || precedence(exp[i]) > precedence(peek()))
						break;
					s[k++] = pop();
				}
				push(exp[i]);
			}
		}
	}
	while(top != -1)
		s[k++] = pop();
}


void infixToPrefix(char exp[], char s[], int n){
	reverse(exp,n);
	int k = 0;
	for(int i = 0; i < n ; i++){
		if(exp[i] != '+' && exp[i] != '-' && exp[i] != '*' && exp[i] != '/' ){
			s[k++] = exp[i];
		}
		else{
			if(top == -1 || precedence(exp[i]) > precedence(peek())) 
				push(exp[i]);
			else{
				while(true){
					if( top == -1 || precedence(exp[i]) > precedence(peek()))
						break;
					s[k++] = pop();
				}
				push(exp[i]);
			}
		}
	}
	while(top != -1)
		s[k++] = pop();
	int n2 = length(s);
	reverse(s,n2);
}

int precedence(char c){
	if(c == '^') return 3;
	if(c == '*' || c == '/') return 2;
	if(c == '+' || c == '-') return 1;
	return -1;
}
void reverse(char s[], int n){
	for(int i = 0; i < n/2 ; i++){
		char temp = s[i];
		s[i] = s[n-i-1];
		s[n-i-1] = temp;
	}
}
void print(char s[]){
	for(int i = 0; s[i] != '\0'; i++ ) 
		cout<<s[i];
	cout<<endl;
}

void push(char x){
	if( top == size-1){
		return;
	}
	arr[++top] = x;
}
char peek(){
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
int length(char ch[]){
	int l = 0;
	for(int i = 0; i < size && ch[i] != '\0'; i++){
		l++;
	}
	return l;
}
