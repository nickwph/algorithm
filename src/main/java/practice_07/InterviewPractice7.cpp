#include <iostream>

// node structure
struct Node
{
	int value;
	Node *next;

	Node(int value, Node *next = NULL)
	{
		this->value = value;
		this->next = next;
	}
};

// check if the list has loop
bool is_loop(Node *head)
{
	if (!head) return false;
	Node *slow_trace = head;
	Node *fast_tract = head;
	while (fast_tract && fast_tract->next) {
		slow_trace = slow_trace->next;
		fast_tract = fast_tract->next->next;
		if (slow_trace == fast_tract) return true;
	}
	return false;
}

// check meet up if list is loop
bool check_meet_up_with_loop(Node *head_1, Node *head_2)
{
	// todo: infinite loop if not meeting up
	while (head_1 != head_2 && head_1 && head_2) {
		head_1 = head_1->next;
		head_2 = head_2->next;
		if (head_2->next) head_2 = head_2->next;
	}
	return head_1 == head_2 && head_1 && head_2;
}

// check meet up if list is not loop
bool check_meet_up_without_loop(Node *head_1, Node *head_2)
{
	Node *tail_1 = head_1;
	Node *tail_2 = head_2;
	while (tail_1->next) tail_1 = tail_1->next;
	while (tail_2->next) tail_2 = tail_2->next;
	return tail_1 == tail_2;
}

#if false

int main()
{
	// list 1
	Node *node_9 = new Node(9);
	Node *node_8 = new Node(8, node_9);  // meet of list 1 and 2
	Node *node_7 = new Node(7, node_8);
	Node *node_6 = new Node(6, node_7);
	Node *node_5 = new Node(5, node_6);
	Node *head_1 = node_5;
	printf("%s\n", is_loop(head_1) == false ? "true" : "false");

	// list 2, will meet with list 1
	Node *node_4 = new Node(4, node_8);
	Node *node_3 = new Node(3, node_4);
	Node *node_2 = new Node(2, node_3);
	Node *head_2 = node_2;
	printf("%s\n", is_loop(head_2) == false ? "true" : "false");

	// list 3, separate list
	Node *node_1 = new Node(1);
	Node *node_0 = new Node(0, node_1);
	Node *head_3 = node_0;
	printf("%s\n", is_loop(head_3) == false ? "true" : "false");

	// list 4 with loop
	Node *node_15 = new Node(15);
	Node *node_14 = new Node(14, node_15);
	Node *node_13 = new Node(13, node_14);
	Node *node_12 = new Node(12, node_13);
	Node *node_11 = new Node(11, node_12);
	node_15->next = node_11;
	Node *head_4 = node_11;
	printf("%s\n", is_loop(head_4) ? "true" : "false");  // true

	// list 5 same loop with 4
	Node *node_25 = new Node(25, node_14);
	Node *node_24 = new Node(24, node_25);
	Node *head_5 = node_24;
	printf("%s\n", is_loop(head_5) ? "true" : "false");  // true

	// list 6, separate loop
	Node *node_35 = new Node(35);
	Node *node_34 = new Node(34, node_35);
	node_35->next = node_34;
	Node *head_6 = node_34;
	printf("%s\n", is_loop(head_6) ? "true" : "false");  // true

	// checking
	printf("%s\n", check_meet_up_without_loop(head_1, head_2) == true ? "true" : "false");
	printf("%s\n", check_meet_up_without_loop(head_1, head_3) == false ? "true" : "false");
	printf("%s\n", check_meet_up_with_loop(head_4, head_5) == true ? "true" : "false");
	printf("%s\n", check_meet_up_with_loop(head_4, head_6) == false ? "true" : "false");
}

#endif
