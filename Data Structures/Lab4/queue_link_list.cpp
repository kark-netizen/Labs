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
void enqueue(int x){
	node* temp = getNewNode(x);
	if ( head == NULL){
		head = temp;
		return;
	}
	temp->next = head;
	head = temp;
}
int dequeue(){
	if( head == NULL){
		cout << "Queue Empty " << endl;
		return -99999;
	}
	node *trav = head;
	if ( head -> next == NULL){
		int x = head->val;
		head = NULL;
		return x;
	}
	while ( trav->next->next != NULL){
		trav = trav->next;
	}
	node *temp = trav->next;
	int x = temp->val;
	trav->next = NULL;
	delete(temp);
	return x;
}
int peek(){
	if( head == NULL){
		cout << "Queue Empty " << endl;
		return -99999;
	}
	return head->val;
}
void print(){
	if(head == NULL){
		cout << "Queue Empty" << endl;
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
	cout<< "T to Terminate" << endl;
	cout<< "E to Enqueue" << endl;
	cout<< "D to Dequeue" << endl;
	cout<< "K to Peek" << endl;
	cout<< "P to Print" << endl;
	char ch;
	cin >> ch;
	while( ch != 'T'){
		if( ch == 'E'){
			int x ; 
			cin >> x;
			enqueue(x);
		}
		else if( ch == 'D'){
			cout << "Dequeue Element: " << dequeue() << endl;
		}
		else if( ch == 'K'){
			cout << "Top Element: " << peek() << endl;
		}
		else if ( ch == 'P'){
			cout << "Queue: ";
			print();
		}
		cin >> ch;
	}
}
