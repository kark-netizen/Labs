#include<bits/stdc++.h>
using namespace std;

#define size 100
char arr[size];
int top = -1;

void push(char x);
int peek();
int pop();
void printStack();

void infixToPostfix(char exp[],char s[], int n);
void infixToPrefix(char exp[],char s[] , int n);
int evaluatePostfix(char exp[], int num[], int n);
int evaluatePrefix(char exp[], int n);
void print(char s[]);
int precedence(char c);
void reverse(char s[],int n);
int length(char ch[]);
int convert(char s[],int num[]);
int pow2(int x);

int main(){
#ifndef ONLINE_JUDGE
        freopen("input.txt","r",stdin);
        freopen("output.txt","w",stdout);
#endif
	/*  int num[100], k = 0;
	//
	gets(exp);
	int n = length(exp);
	cout<<evaluatePostfix(exp,n)<<endl;
	cout<<"Write Prefix Expression"<<endl;
	n = length(exp);
	gets(exp);
	cout<<evaluatePrefix(exp,n)<<endl; */ 

	char exp[100]; int num[100]; int n = length(exp);
	cout<<"Write Postfix Expression"<<endl;
	gets(exp);
	convert(exp,num);
	cout<<evaluatePostfix(exp,num,n);
	//cout<<num[1]<<" "<<num[3];
}

int evaluatePostfix(char exp[], int num[] , int n){
	for(int i = 0; i < n; i++){
		if(exp[i] != '+' && exp[i] != '-' && exp[i] != '*' && exp[i] != '/' && exp[i] != ' '){
			cout<<num[i]<<endl;;
			push(num[i]);
		}
		else if(exp[i] != ' '){
			int x, n1 = pop() , n2 = pop();
			//cout<<n1<<"  "<<n2<<endl;
			if(exp[i] == '+')
				x = n1+n2;
			else if(exp[i] == '-')
				x = n1 - n2;
			else if(exp[i] == '*')
				x = n1 * n2;
			else if(exp[i] == '/')
				x = n1 / n2;
			push(x);
		}
	}
	int x = pop();
	return x;
}
int evaluatePrefix(char exp[], int n){
	reverse(exp,n);
	for(int i = 0; i < n; i++){
		if(exp[i] != '+' && exp[i] != '-' && exp[i] != '*' && exp[i] != '/' ){
			push(exp[i]);
		}
		else{
			int x, n1 = pop()-'0' , n2 = pop()-'0';
			//cout<<n1<<"  "<<n2<<endl;
			if(exp[i] == '+')
				x = n1+n2;
			else if(exp[i] == '-')
				x = n1 - n2;
			else if(exp[i] == '*')
				x = n1 * n2;
			else if(exp[i] == '/')
				x = n1 / n2;
			push(x+'0');
		}
	}
	int x = pop() - '0';
	return x;
}

int pow2(int x){
	int sum = 1;
	for(int i = 1; i <= x; i++){
		sum *= 10;
	}
	return sum;
}
int convert(char exp[], int num[]){
	int power = 0, sum = 0, n = length(exp);
	for(int i = n-1; i >= 0; i--){
		if(exp[i] == ' '){
			power = 0; sum = 0;
		}
		if(exp[i] >= 47 && exp[i]  <= 57){
			sum += pow2(power++) * (exp[i] - '0');
		}
		if(exp[i-1] == ' '){
			num[i] = sum;
		}
	}
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
int peek(){
	if(top == -1){
		return -1;
	}
	return arr[top];
}
int pop(){
	if(top == -1){
		return -1;
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
