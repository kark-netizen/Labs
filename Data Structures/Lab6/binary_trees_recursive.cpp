#include<iostream>
using namespace std;

struct node
{
	int val;
	node *left;
	node *right;
};

node* getNewNode(int x){
	node *temp = new node;
	temp->val = x;
	temp->left = NULL;
	temp->right = NULL;
	return temp;
}

node* rootNode = NULL;

node* insert(node* root, int x){
	if(root == NULL){
		node *temp = getNewNode(x);
		return temp;
	}
	cout << "Current Value : " << root->val << endl;
	cout << "Insert Left or Right" << endl;
	char ch;
	cin >> ch;
	if(ch == 'L')
		root->left = insert(root->left , x);
	else if(ch == 'R')
		root->right = insert(root->right , x);
	else
		cout << "INVALID!" << endl;
}

void inorder(node* root){
	if(root == NULL){
		return;
	}
	if(root->left == NULL && root->right == NULL){
		cout << root->val << " ";
		return;
	}
	inorder(root->left);
	cout << root->val << " " ;
	inorder(root->right);
}
void preorder(node* root){
	if(root == NULL){
		return;
	}
	if(root->left == NULL && root->right == NULL){
		cout << root->val << " ";
		return;
	}
	cout << root->val << " " ;
	inorder(root->left);
	inorder(root->right);
}
void postorder(node* root){
	if(root == NULL){
		return;
	}
	if(root->left == NULL && root->right == NULL){
		cout << root->val << " ";
		return;
	}
	inorder(root->left);
	inorder(root->right);
	cout << root->val << " " ;
}
int leaves = 0;
node* count(node* root){
	if(root == NULL){
		return root;
	}
	if(root->left == NULL && root->right == NULL){
		cout << root->val << " " << endl;
		leaves ++;
	}
	count(root->left);
	count(root->right);
}
int main(){

	
	cout <<"I Insert" << endl;
	cout <<"N Inorder" << endl;
	cout <<"R Preorder" << endl;
	cout <<"O PostOrder" << endl;
	cout <<"L Leaves" << endl;
	cout <<"T Terminate" << endl;
	
	cout << "Input Choice : ";
	char ch;
	cin >> ch;
	while(ch != 'T'){
		if(ch == 'I'){
			cout << "Input Number : ";
			int x;
			cin >> x;
			if(rootNode == NULL){
				rootNode = insert(rootNode, x);
			}
			else
				insert(rootNode, x);
		}
		else if(ch == 'N'){
				cout << "Inorder   : ";
				inorder(rootNode);
				cout<<endl;
		}
		else if(ch == 'R'){
			cout << "Postorder   : ";
			preorder(rootNode);
			cout<<endl;
		}
		else if(ch == 'O'){
			cout << "PostOrder   : ";
			postorder(rootNode);
			cout<<endl;
		}
		else if(ch == 'L'){
			count(rootNode);
			cout << "Leaves    : " << leaves << endl;
		}
		else{
			return 0;
		}
		cout << "Input Choice : ";
		cin >> ch;
	}
	
}
/*
rootNode = insert(rootNode , 10);
	cout << rootNode->val;
	insert(rootNode , 20);
	cout << rootNode->left->val;
*/
