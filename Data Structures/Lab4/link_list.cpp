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
void insertHead(int x){
	node* temp = getNewNode(x);
	if ( head == NULL){
		head = temp;
		return;
	}
	temp->next = head;
	head = temp;
}
void insertTail(int x){
	node* temp = getNewNode(x);
	if ( head == NULL){
		head = temp;
		return;
	}
	node *trav = head;
	while( trav->next != NULL){
		trav = trav->next;
	}
	trav->next = temp;
}
void insertBefore(int p, int x){
	if(head == NULL){
		cout << "List Empty" << endl;
		return;
	}
	node *temp = getNewNode(x);
	node *trav = head->next;
	node *prev = head;
	if( head->val == p){
		temp->next = head;
		head = temp;
		return;
	}
	while( trav != NULL){
		if( trav->val == p){
			prev->next = temp;
			temp->next = trav;
			return;
		}
		trav = trav->next;
		prev = prev->next;
	}
	cout << "Element Not Found" << endl;
}
void insertAfter(int p, int x){
	if(head == NULL){
		cout << "List Empty" << endl;
		return;
	}
	node *temp = getNewNode(x);
	node *trav = head;
	while( trav != NULL){
		if(trav->val == p){
			temp->next = trav->next;
			trav->next = temp;
			return;
		}
		trav = trav->next;
	}
	cout << "Element Not Found" << endl;
}

void remove(int x){
	node *trav = head->next;
	node *prev = head;
	if( head->val == x){
		head = head->next;
		delete(prev);
	}
	while( trav != NULL){
		if ( trav->val == x){
			prev->next = trav->next;
			delete(trav);
			return;
		}
		trav = trav->next;
		prev = prev->next;
	}
	cout << "Element Not Found" << endl;
}
void print(){
	if(head == NULL){
		cout << "List Empty" << endl;
		return;
	}
	node *trav = head;
	while(trav != NULL){
		cout<< trav->val << " ";
		trav = trav->next;
	}
	cout << endl;
}
int main(){
	cout<< "E to Terminate" << endl;
	cout<< "H to Insert at Head" << endl;
	cout<< "T to Insert at Tail" << endl;
	cout<< "A to Insert After" << endl;
	cout<< "B to Insert Before" << endl;
	cout<< "R to Remove" << endl;
	cout<< "P to Print" << endl;
	char ch;
	cin >> ch;
	while( ch != 'E'){
		if( ch == 'H'){
			int x ; 
			cin >> x;
			insertHead(x);
		}
		else if( ch == 'T'){
			int x ; 
			cin >> x;
			insertTail(x);
		}
		else if( ch == 'A'){
			int x , p ; 
			cin >> x >> p;
			insertAfter(p , x);
		}
		else if( ch == 'B'){
			int x , p ; 
			cin >> x >> p;
			insertBefore(p , x);
		}
		else if ( ch == 'R'){
			int x ; 
			cin >> x;
			remove(x);
		}
		else{
			print();
		}
		cin >> ch;
	}
}
/*

H 10
H 20
H 30
P
T 0
T -20
T -40
P
A -10 0
A -30 -20
P
B -20 -20
P
R -20
P
*/

