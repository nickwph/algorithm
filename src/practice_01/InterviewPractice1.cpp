#include <iostream>

struct Node
{
	int value;
	Node *left;
	Node *right;

	Node(int value, Node *left = NULL, Node *right = NULL)
	{
		this->value = value;
		this->left = left;
		this->right = right;
	}
};

Node *node_root = NULL;
Node *node_temp = NULL;

void visit(Node *node)
{
	if (node_temp == NULL) node_root = node;  // set head
	else node_temp->right = node;  // make right of them to this node
	node->left = node_temp;  // make temp to the left of this node
	node_temp = node;  // next node
}

void depth_first_recursive_traversal_in_order(Node *node)
{
	if (!node) return;
	depth_first_recursive_traversal_in_order(node->left);
	visit(node);
	depth_first_recursive_traversal_in_order(node->right);
}

#if false

int main()
{
	// tree
	Node *node_5 = new Node(5);
	Node *node_7 = new Node(7);
	Node *node_9 = new Node(9);
	Node *node_1 = new Node(1);
	Node *node_6 = new Node(6, node_5, node_7);
	Node *node_0 = new Node(0, node_9, node_1);
	Node *node_8 = new Node(8, node_6, node_0);

	// conversion
	node_root = node_8;
	node_temp = NULL; // null
	depth_first_recursive_traversal_in_order(node_8);

	// answer should be: 5 6 7 8 9 0 1
	node_temp = node_root;
	while (node_temp) {
		printf("%d ", node_temp->value);
		node_temp = node_temp->right;
	}
}

#endif
