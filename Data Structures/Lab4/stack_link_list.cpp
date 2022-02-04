#include<bits/stdc++.h>
using namespace std;

struct node{
	int val;
	struct node* next;
};

node* head = NULL;
node* getNewNode(int x){
	node* temp = new node;
	temp->next = NULL;
	temp->val = x;
	return temp;
}
void push(int x){
	node* temp = getNewNode(x);
	if ( head == NULL){
		head = temp;
		return;
	}
	temp->next = head;
	head = temp;
}
int pop(){
	if( head == NULL){
		cout << "Stack Empty " << endl;
		return -99999;
	}
	node *temp = head;
	head = head->next;
	return temp->val;
	delete(temp);
}
int peek(){
	if( head == NULL){
		cout << "Stack Empty " << endl;
		return -99999;
	}
	return head->val;
}
void print(){
	if(head == NULL){
		cout << "Stack Empty" << endl;
		return;
	}
	node *trav = head;
	while(trav != NULL){
		cout<< trav->val << " ";
		trav = trav->next;
	}
	cout << endl;
}
int main()
{
	cout<< "E to Terminate" << endl;
	cout<< "P to Push" << endl;
	cout<< "O to Pop" << endl;
	cout<< "K to Peek" << endl;
	cout<< "D to Display" << endl;
	char ch;
	cin >> ch;
	while( ch != 'E'){
		if( ch == 'P'){
			int x ; 
			cin >> x;
			push(x);
		}
		else if( ch == 'O'){
			cout << "Popped Element: " << pop() << endl;
		}
		else if( ch == 'K'){
			cout << "Top Element: " << peek() << endl;
		}
		else if ( ch == 'D'){
			cout << "Stack: ";
			print();
		}
		cin >> ch;
	}
}
