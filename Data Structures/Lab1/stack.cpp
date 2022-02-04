#include<bits/stdc++.h>
using namespace std;

int size = 3;
int arr[3];
int top = -1;

void push(int x);
int topEle();
int pop();
void printStack();

int main(){
	cout<<"Input 'E' to Terminate"<<endl;
	cout<<"Input 'P' to Push"<<endl;
	cout<<"Input 'O' to Pop"<<endl;
	cout<<"Input 'T' to display top element"<<endl;
	cout<<"Input 'D' to Display Stack"<<endl;
	char ch; cin>>ch;
	while(ch!='E'){
		if(ch == 'P'){
			cout<<"Input Number"<<endl;
			int x; cin>>x;
			push(x);
		}
		else if(ch == 'O'){
			cout<<pop()<<endl;
		}
		else if(ch == 'T'){
			cout<<topEle()<<endl;
		}
		else if(ch == 'D'){
			printStack();
		}
		cout<<"What do you want to do?"<<endl;
		cin>>ch;
	}
}

void push(int x){
	if( top == size-1){
		cout<<"Stack full"<<endl;
		return;
	}
	arr[++top] = x;
}
int topEle(){
	if(top == -1){
		cout<<"Stack empty"<<endl;
		return -1;
	}
	return arr[top];
}
int pop(){
	if(top == -1){
		cout<<"Stack empty";
		return -1;
	}
	return arr[top--];	
}
void printStack(){
	for(int i=0;i<=top;i++) cout<<arr[i]<<" ";
	cout<<endl;
}
