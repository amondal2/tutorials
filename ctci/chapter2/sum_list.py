# doing the rest of these in python bc i'm wasting too much time
# with java language nuances

class Node:
    def __init__(self,val):
        self.val = val
        self.next = None

def add_two_linked_lists(l1, l2):
    """ method to add two linked lists where each
    node contains a single digit, stored in reverse
    order """
    temp = Node(0)
    current, carry = temp, 0

    while l1 or l2:
        val = carry
        if l1:
            val += l1.val
            l1 = l1.next
        if l2:
            val += l2.val
            l2 = l2.next
        carry, val = divmod(val, 10)
        current.next = Node(val)
        current = current.next

    if carry == 1:
        current.next = Node(1)

    return temp.next

if __name__ == '__main__':
    node1 = Node(5)
    node2 = Node(6)
    node1.next = node2
    # 5->6 so 65 is the number representation
    node3 = Node(7)
    node4 = Node(4)
    node3.next = node4
    # 7 -> 4 so 47 is the number representation
    # 65 + 47 = 112 so output should be 2->1->1
    sum_node = add_two_linked_lists(node1, node3)
    assert sum_node.val == 2
    assert sum_node.next.val == 1
    assert sum_node.next.next.val == 1
    assert sum_node.next.next.next is None
