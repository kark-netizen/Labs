#include <iostream>
using namespace std;

#define size 3
#define len 10
char cqueue[size][len];
int front = -1, rear = -1;

void push(char x[]){
	if(front == -1 && rear == -1){
		front = 0;
	}
	else if((rear+1)%size == front){
		cout<<"Stack Full"<<endl;
		return;
	}
	++rear;
	for(int i = 0; x[i] != '\0'; i++){
		cqueue[rear][i] = x[i];
	}
}
void display(){
	for(int i = front; i <= rear; i++){
		for(int j = 0; cqueue[i%size][j] != '\0'; j++){
			cout<<cqueue[i%size][j];
			//cout<<i<<" "<<j;
		}
		cout<<endl;
	}
	cout<<endl;
}

void remove(){
	if(front == -1 && rear == -1){
		cout<<"Queue Empty"<<endl;
		return;
	}
	if((front)%size == rear){
		for(int j = 0; cqueue[front][j] != '\0'; j++)
			cqueue[front][j] = '\0';
		front = -1; rear = -1;
		return;
	}
	for(int j = 0; cqueue[front][j] != '\0'; j++){
		cqueue[front][j] = '\0';
	}
	front++;
}

int main(){

	cout<<"Input 'E' to Terminate"<<endl;
	cout<<"Input 'P' to Push"<<endl;
	cout<<"Input 'O' to Pop"<<endl;
	cout<<"Input 'D' to Display Queue"<<endl;
	char ch; cin>>ch;
	while(true){
		if(ch == 'P'){
			cout<<"Input String"<<endl;
			char x[10]; 
			gets(x);
			push(x);
		}
		else if(ch == 'O'){
			remove();
		}
		else if(ch == 'D'){
			display();
		}
		cout<<"What do you want to do?"<<endl;
	}
}


/*
	for(int i = 0; i < 3; i++){
		char exp[10];
		gets(exp);
		push(exp);
		display();
	}
	remove();
	display();
	remove();
	display();
	remove();
	display();
	remove();
	
	for(int i = 0; i < 3; i++){
		char exp[10];
		gets(exp);
		push(exp);
		display();
	}
	

*/
