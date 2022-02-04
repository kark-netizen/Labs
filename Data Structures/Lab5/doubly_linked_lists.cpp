#include <iostream>
using namespace std;

struct node{
	int val;
	struct node* prev;
	struct node* next;
};

node* head = NULL;
node* tail = NULL;

node* getNewNode(int x){
	node* temp = new node;
	temp->val = x;
	temp->next = NULL;
	temp->prev = NULL;
	return temp;
}
void insert(int x){
	node* temp = getNewNode(x);
	if(head == NULL){
		head = temp;
		tail = temp;
		return;
	}
	tail->next = temp;
	temp->prev = tail;
	tail = temp;
}
void remove(){
	if(head == NULL){
		cout << "Empty" << endl;
		return;
	}
	tail = tail->prev;
	tail->next = NULL;
}
void insertAfter(int x, int p){
	if(head == NULL){
		cout << "Empty" << endl;
		return;
	}
	node* temp = getNewNode(x);
	node* trav = head;
	while(trav != tail){
		if(trav->val == p){
			temp->next = trav->next;
			trav->next->prev = temp;
			temp->prev = trav;
			trav->next = temp;
			return;
		}
		trav = trav->next;
	}
	if( tail->val == p){
		insert(x);
	}
}
void insertBefore(int x, int p){
	if(head == NULL){
		cout << "Empty" << endl;
		return;
	}
	node* temp = getNewNode(x);
	node* trav = head;
	if(head->val == p){
		temp->next = head;
		head->prev = temp;
		head = temp;
		return;
	}
	while(trav != NULL){
		if(trav->val == p){
			temp->next = trav;
			temp->prev = trav->prev;
			trav->prev->next = temp;
			trav->prev = temp;
			return;
		}
		trav = trav->next;
	}
}
void insertAt(int x , int p){
	if(head == NULL){
		cout << "Empty" << endl;
		return;
	}
	node* temp = getNewNode(x);
	node* trav = head;
	int i = 0 ;
	if(i++ == p){
		temp->next = head;
		head->prev = temp;
		head = temp;
		return;
	}
	while(trav != NULL){
		if(i++ == p){
			temp->next = trav->next;
			trav->next->prev = temp;
			temp->prev = trav;
			trav->next = temp;
			return;
		}
		trav = trav->next;
	}
}
void removeAt( int p){
	if(head == NULL){
		cout << "Empty" << endl;
		return;
	}
	node* trav = head;
	if(p == 0){
		head = head->next;
		head->prev = NULL;
		return;
	}
	int i = 0 ; 
	while(trav != NULL){
		if( p == ++i){
			trav->prev->next = trav->next;
			trav->next->prev = trav->prev;
			return;
		}
		trav = trav->next;
	}
}
void print(){
	node* trav = head;
	while(trav != NULL){
		cout << trav->val << " ";
		trav = trav->next;
	}
	cout << endl;
}
int main(){
	cout<<"I Insert at Tail"<<endl;
	cout<<"R Remove from Rear"<<endl;
	cout<<"N Insert at Index"<<endl;
	cout<<"D Delete Element"<<endl;
	cout<<"A Insert After Element"<<endl;
	cout<<"B Insert Before Element"<<endl;
	cout<<"P Print"<<endl;
	cout<<"T Terminate"<<endl;
	
	char ch;
	cin >> ch;
	while (ch != 'T'){
	
		//cout<<"Enter a choice: ";
		if( ch == 'I'){
			//cout<<"Enter the element to be inserted: ";
			int x;
			cin>>x;
			insert(x);
		}
		else if( ch == 'R'){
			remove();
		}
		
		else if( ch == 'N'){
			int x , p;
			//cout<<"Enter the element to be inserted: ";
			//cout<<"Enter the position to insert at: ";
			cin>> x >> p;
			insertAt(x, p);
		}
		
		else if( ch == 'D'){
			int p;
			//cout<<"Enter the position to delete from: ";
			cin>> p;
			removeAt(p);
		}
		
		else if( ch == 'A'){
			int x , p;
			cin>> x >> p;
			//cout<<"Enter the element to be inserted: ";
			//cout<<"Enter the element after which to insert: ";
			insertAfter(x, p);
		}
		
		else if( ch == 'B'){
			//cout<<"Enter the element to be inserted: ";
			//cout<<"Enter the element before which to insert: ";
			int x , p;
			cin>> x >> p;
			insertBefore(x, p);
		}
		else if( ch == 'P'){
			print();
		}	
		cin >> ch;	
		
	}
	return 0;
}

/*
	int ch, ele, pos;
	
	cout<<"1. Insert an element at the rear end of the list"<<endl;
	cout<<"2. Delete an element from the rear end of the list"<<endl;
	cout<<"3. Insert an element at a given position of the list"<<endl;
	cout<<"4. Delete an element from a given position of the list"<<endl;
	cout<<"5. Insert an element after another element"<<endl;
	cout<<"6. Insert an element before another element"<<endl;
	cout<<"7. Print the list"<<endl;
	cout<<"8. Exit"<<endl;
	
	cin>>ch;
	
	switch(ch){
		case 1:
			cout<<"Enter the element to be inserted: ";
			cin>>ele;
			insert(ele);
			
		case 2:
			remove();
			
		case 3:
			cout<<"Enter the element to be inserted: ";
			cin>>ele;
			cout<<"Enter the position to insert at: ";
			cin>>pos;
			insertAt(ele, pos);
		
		case 4:
			cout<<"Enter the position to be deleted from: ";

	}
*/
