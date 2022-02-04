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
	if( x < root->val){
		root->left = insert(root->left , x);
	}
	else if( x > root->val){
		root->right = insert(root->right , x);
	}
}
void search(node* root , int find){
	if(root->val == find){
		cout << "Element Found " << endl;
		return;
	}
	if(root->left == NULL && root->right == NULL){
		cout << "Element Not Found" << endl;
		return;
	}
	else if(find <= root->val ){
		search(root->left , find);
	}
	else{
		search(root->right , find);
	}
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
		cout << root->val << " ";
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
	cout <<"S Search" << endl;
	cout <<"T Terminate" << endl;
	
	char ch;
	cin >> ch;
	
	while(ch != 'T'){
		if(ch == 'I'){
			int x;
			cin >> x;
			if(rootNode == NULL)
				rootNode = insert(rootNode, x);
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
			cout << "Leaves    : " << leaves;
		}
		else if(ch == 'S'){
			//cout << "Input Search Element " << endl;
			int s ; cin >> s;
			search(rootNode , s);
		}
		else{
			return 0;
		}
		cin >> ch;
	}
}

/*
	char ch;
	cin >> ch;
	cout <<"I Insert" << endl;
	cout <<"N Inorder" << endl;
	cout <<"R Preorder" << endl;
	cout <<"O PostOrder" << endl;
	cout <<"L Leaves" << endl;
	cout <<"T Terminate" << endl;
	while(ch != 'T'){
		if(ch == 'I'){
			int x;
			cin >> x;
			if(rootNode == NULL)
				rootNode = insert(rootNode, x);
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
			cout << "Leaves    : " << leaves;
		}
		else{
			return 0;
		}
		cin >> ch;
	}
*/
