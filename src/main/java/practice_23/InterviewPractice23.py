# node structure
class Node:
    value = None
    next = None

    def __init__(self, value, next_node=None):
        self.value = value
        self.next = next_node


# reverse the linked list and return the head node
def reverse_linked_list(head):
    reversed_head = None
    last_node = None
    node = head
    while node:
        next_node = node.next
        if next_node is None: reversed_head = node
        node.next = last_node
        last_node = node
        node = next_node
    return reversed_head

# linked list
node_9 = Node(9)
node_8 = Node(8, node_9)
node_7 = Node(7, node_8)
node_6 = Node(6, node_7)
node_5 = Node(5, node_6)
node_4 = Node(4, node_5)
node_3 = Node(3, node_4)
node_2 = Node(2, node_3)
node_1 = Node(1, node_2)
node_head = node_1

# testing
node_reversed_head = reverse_linked_list(node_head)
node_temp = node_reversed_head
while node_temp:
    print node_temp.value,
    node_temp = node_temp.next