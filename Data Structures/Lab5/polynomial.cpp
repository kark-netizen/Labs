#include<iostream>
using namespace std;

struct node {
	int power;
	int coeff;
	node* next;
	node* prev;
};

node* insert_term(node* list, int power, int coeff) {
	node* temp = new node;
	node* curr = list;
	temp -> power = power;
	temp -> coeff = coeff;
	if(list == NULL) {
		list = temp;
		list -> next = list -> prev = NULL;
		return list;
	}
	while(curr -> next != NULL)
		curr = curr -> next;
	curr -> next = temp;
	temp -> prev = curr;
	temp -> next = NULL;
	return list;
}

void disp(node* list) {
	while(list != NULL) {
		if(list -> power == 0)
			cout << list -> coeff;
		else {
			cout << list -> coeff << "x^" << list -> power;
			if(list -> next != NULL && list -> next -> coeff >= 0)
				cout << "+";
		}
		list = list -> next;
	}
	cout << endl;
}

node* add(node* p1, node* p2, node* ans) {
	int power, coeff;
	while(p1 != NULL && p2 != NULL) {
		if(p1 -> power == p2 -> power) {
			coeff = p1 -> coeff + p2 -> coeff;
			power = p1 -> power;
			p1 = p1 -> next;
			p2 = p2 -> next;
		}
		else if(p1 -> power > p2 -> power) {
			coeff = p1 -> coeff;
			power = p1 -> power;
			p1 = p1 -> next;
		}
		else {
			coeff = p2 -> coeff;
			power = p2 -> power;
			p2 = p2 -> next;
		}
		ans = insert_term(ans, power, coeff);
	}
	if(p1 != NULL) {
		while(p1 != NULL) {
			ans = insert_term(ans, p1 -> power, p1 -> coeff);
			p1 = p1 -> next;
		}
	}
	else if(p2 != NULL){
		while(p2 != NULL) {
			ans = insert_term(ans, p2 -> power, p2 -> coeff);
			p2 = p2 -> next;
		}
	}
	return ans;
}

int main() {
	node *p1, *p2, *ans;
	p1 = p2 = ans = NULL;
	int np1, np2;
	int power, coeff;
	cout << "Enter the number of terms in the first polynomial: ";
	cin >> np1;
	cout << "Enter the number of terms in the second polynomial: ";
	cin >> np2;
	cout << "Polynomial 1 \n";
	for(int i = 0; i < np1; i++) {
		cout << "Enter the power of term " << i+1 << ": ";
		cin >> power;
		cout << "Enter the coefficient of term " << i+1 << ": ";
		cin >> coeff;
		p1 = insert_term(p1, power, coeff);
	}
	cout << "Polynomial 2 \n";
	for(int i = 0; i < np2; i++) {
		cout << "Enter the power of term " << i+1 << ": ";
		cin >> power;
		cout << "Enter the coefficient of term " << i+1 << ": ";
		cin >> coeff;
		p2 = insert_term(p2, power, coeff);
	}
	
	cout << "Polynomial 1: ";
	disp(p1);
	cout << "Polynomial 2: ";
	disp(p2);
	ans = add(p1, p2, ans);
	cout << "Sum: ";
	disp(ans);
	return 0;
}

