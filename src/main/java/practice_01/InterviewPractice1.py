# node structure
class Node:
    value = None
    left = None
    right = None

    # constructor
    def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right


# what to do with a node.
def visit(node):
    global node_temp
    global node_root
    if not node_temp: node_root = node  # head
    else: node_temp.right = node  # make right of temp to this
    node.left = node_temp  # make temp to this left
    node_temp = node  # next node


# bfs traversal
def depth_first_recursive_traversal_in_order(node):
    if node is None: return
    depth_first_recursive_traversal_in_order(node.left)
    visit(node)
    depth_first_recursive_traversal_in_order(node.right)


# a binary tree and display how was it before reflection
node_5 = Node(5)
node_7 = Node(7)
node_9 = Node(9)
node_1 = Node(1)
node_6 = Node(6, node_5, node_7)
node_0 = Node(0, node_9, node_1)
node_8 = Node(8, node_6, node_0)

# conversion
node_root = node_8
node_temp = None
depth_first_recursive_traversal_in_order(node_root)

# answer should be: 5 6 7 8 9 0 1
node_temp = node_root
while node_temp:
    print node_temp.value,
    node_temp = node_temp.right