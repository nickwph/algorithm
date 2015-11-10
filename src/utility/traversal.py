def visit(node):
    pass


"""
Depth First, Recursive
"""


def depth_first_recursive_traversal_pre_order(node):
    if node is None: return
    visit(node)
    depth_first_recursive_traversal_pre_order(node.left)
    depth_first_recursive_traversal_pre_order(node.right)


def depth_first_recursive_traversal_in_order(node):
    if node is None: return
    depth_first_recursive_traversal_in_order(node.left)
    visit(node)
    depth_first_recursive_traversal_in_order(node.right)


def depth_first_recursive_traversal_post_order(node):
    if node is None: return
    depth_first_recursive_traversal_post_order(node.left)
    depth_first_recursive_traversal_post_order(node.right)
    visit(node)


"""
Depth First, Iterative
"""


def depth_first_iterative_traversal_pre_order(root):
    stack = [root]
    while len(stack) > 0:
        node = stack.pop()  # get the last item
        visit(node)
        if node.left: stack.append(node.left)
        if node.right: stack.append(node.right)


def depth_first_iterative_traversal_in_order(root):
    stack = [root]
    while len(stack) > 0:
        node = stack.pop()  # get the last item
        if node.left: stack.append(node.left)
        visit(node)
        if node.right: stack.append(node.right)


def depth_first_iterative_traversal_post_order(root):
    stack = [root]
    while len(stack) > 0:
        node = stack.pop()  # get the last item
        if node.left: stack.append(node.left)
        if node.right: stack.append(node.right)
        visit(node)


"""
Breadth First, Iterative
"""


def breadth_first_iterative_traversal_pre_order(root):
    queue = [root]
    while len(queue) > 0:
        node = queue.pop(0)  # get the head item
        visit(node)
        if node.left: queue.append(node.left)
        if node.right: queue.append(node.right)


def breadth_first_iterative_traversal_in_order(root):
    queue = [root]
    while len(queue) > 0:
        node = queue.pop(0)  # get the head item
        if node.left: queue.append(node.left)
        visit(node)
        if node.right: queue.append(node.right)


def breadth_first_iterative_traversal_post_order(root):
    queue = [root]
    while len(queue) > 0:
        node = queue.pop(0)  # get the head item
        if node.left: queue.append(node.left)
        if node.right: queue.append(node.right)
        visit(node)
