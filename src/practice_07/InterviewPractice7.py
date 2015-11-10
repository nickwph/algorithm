# node structure
class Node:
    value = None
    next = None

    def __init__(self, value, next_node=None):
        self.value = value
        self.next = next_node


# check if the list has loop
def is_loop(head):
    if not head: return False
    slow_trace = fast_tract = head
    while fast_tract and fast_tract.next:
        slow_trace = slow_trace.next
        fast_tract = fast_tract.next.next
        if slow_trace == fast_tract: return True
    return False


# check meet up if list is loop
def check_meet_up_with_loop(head_1, head_2):
    # todo: infinite loop if not meeting up
    while head_1 != head_2 and head_1 and head_2:
        head_1 = head_1.next
        head_2 = head_2.next
        if head_2.next: head_2 = head_2.next
    return head_1 == head_2 and head_1 is not None and head_2 is not None


# check meet up if list is not loop
def check_meet_up_without_loop(head_1, head_2):
    tail_1 = head_1
    tail_2 = head_2
    while tail_1.next: tail_1 = tail_1.next
    while tail_2.next: tail_2 = tail_2.next
    return tail_1 == tail_2

# list 1
node_9 = Node(9)
node_8 = Node(8, node_9)  # meet of list 1 and 2
node_7 = Node(7, node_8)
node_6 = Node(6, node_7)
node_5 = Node(5, node_6)
head_1 = node_5
print is_loop(head_1) == False

# list 2, will meet with list 1
node_4 = Node(4, node_8)
node_3 = Node(3, node_4)
node_2 = Node(2, node_3)
head_2 = node_2
print is_loop(head_2) == False

# list 3, separate list
node_1 = Node(1)
node_0 = Node(0, node_1)
head_3 = node_0
print is_loop(head_3) == False

# list 4 with loop
node_15 = Node(15)
node_14 = Node(14, node_15)
node_13 = Node(13, node_14)
node_12 = Node(12, node_13)
node_11 = Node(11, node_12)
node_15.next = node_11
head_4 = node_11
print is_loop(head_4)  # true

# list 5 same loop with 4
node_25 = Node(25, node_14)
node_24 = Node(24, node_25)
head_5 = node_24
print is_loop(head_5)  # true

# list 6, separate loop
node_35 = Node(35)
node_34 = Node(34, node_35)
node_35.next = node_34
head_6 = node_34
print is_loop(head_6)  # true

# checking
print
print check_meet_up_without_loop(head_1, head_2) == True
print check_meet_up_without_loop(head_1, head_3) == False
print check_meet_up_with_loop(head_4, head_5) == True
print check_meet_up_with_loop(head_4, head_6) == False
