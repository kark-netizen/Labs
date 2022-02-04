#include <iostream>
using namespace std;

#define size 3
int queue[size];
int front = -1, rear = -1;

void push(int x){
	if(front == -1 && rear == -1){
		front = 0;
	}
	if(rear == size - 1){
		cout<<"Queue Full"<<endl;
		return;
	}
	queue[++rear] = x;
}

int pop(){
	if(front == rear){
		cout<<"Queue Empty"<<endl;
		front = -1;
		rear = -1;
		return -99999;
	}
	return queue[front++];
}

int peek(){
	if(front == rear){
		cout<<"Queue Empty"<<endl;
		front = -1;
		rear = -1;
		return -99999;
	}
	return queue[front];
}

void print(){
	for(int i = front; i <= rear; i++){
		cout<<queue[i]<<" ";
	}
	cout<<endl;
}
bool isFull(){
	if(rear == size-1)
		return true;
	return false;
}
bool isEmpty(){
	if(front == rear)
		return true;
	return false;
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
			if(isFull()) cout<<"Queue Full"<<endl;
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
	cout<<peek()<<endl;
	print();
	push(30);
	print();
	push(40);
	cout<<pop()<<endl;
	cout<<pop()<<endl;
	cout<<pop()<<endl;
	cout<<pop()<<endl;
	
	}
	*/
