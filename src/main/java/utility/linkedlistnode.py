class Node:
    value = None
    next = None

    def __init__(self, value, next_node=None):
        self.value = value
        self.next = next_node