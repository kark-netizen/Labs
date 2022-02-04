#include <iostream>
using namespace std;

#define size 3
int cqueue[size];
int front = -1, rear = -1;

void push(int x){
	if(front == -1 && rear == -1){
		front = 0;
	}
	else if((rear+1)%size == front){
		cout<<"Queue Full"<<endl;
		return;
	}
	cqueue[(++rear)%size] = x;
}

int pop(){
	if(front == -1 && rear == -1){
		cout<<"Queue Empty"<<endl;
		return -9999;
	}
	if((front)%size == rear){
		int temp = front;
		front = -1; rear = -1;
		return cqueue[temp%size];
	}
	return cqueue[(front++)%size];
}
int peek(){
	if(front == -1 && rear == -1){
		cout<<"Queue Empty"<<endl;
		return -9999;
	}
	if((front)%size == rear){
		int temp = front;
		front = -1; rear = -1;
		return cqueue[temp%size];
	}
	return cqueue[(front++)%size];
}
void print(){
	for(int i = 0 ; i <= rear; i++){
		cout<<cqueue[i]<<" ";
	}
	cout<<endl;
}
int main(){
	cout<<"Input 'E' to Terminate"<<endl;
	cout<<"Input 'P' to Push"<<endl;
	cout<<"Input 'O' to Pop"<<endl;
	cout<<"Input 'T' to Peek"<<endl;
	cout<<"Input 'D' to Display Queue"<<endl;
	char ch; cin>>ch;
	while(ch!='E'){
		if(ch == 'P'){
			if((rear+1)%size == front) cout<<"Queue Full"<<endl;
			else{
				cout<<"Input Number"<<endl;
				int x; cin>>x;
				push(x);
			}
		}
		else if(ch == 'O'){
			cout<<pop()<<endl;
		}
		else if(ch == 'T'){
			cout<<peek()<<endl;
		}
		else if(ch == 'D'){
			print();
		}
		cout<<"What do you want to do?"<<endl;
		cin>>ch;
	}
}
/*
	push(10);
	print();
	push(20);
	print();
	push(30);
	print();
	push(40);
	
	cout<<pop()<<endl;
	cout<<pop()<<endl;
	cout<<pop()<<endl;
	cout<<pop()<<endl;
	
	push(40);
	print();
	push(50);
	print();
	push(60);
	print();
	push(70);
	*/
