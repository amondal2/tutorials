class Node:
    def __init__(self,val):
        self.val = val
        self.next = None

def is_palindrome(node):
    # method to check if a linked list is a palindrome
    # O(N) space and time complexity, since we need to
    # visit the list twice and allocate some memory for
    # a stack
    visited = []
    first_pass = node
    while first_pass:
        visited.append(first_pass.val)
        first_pass = first_pass.next

    second_pass = node
    while second_pass:
        reverse_value = visited.pop()
        if second_pass.val != reverse_value:
            return False
        second_pass = second_pass.next

    return True

if __name__ == '__main__':
    node1 = Node(1)
    node2 = Node(2)
    node3 = Node(3)
    node1.next = node2
    node2.next = node3
    assert is_palindrome(node1) == False

    node4 = Node(1)
    node5 = Node(2)
    node6 = Node(2)
    node7 = Node(1)
    node4.next = node5
    node5.next = node6
    node6.next = node7
    assert is_palindrome(node4) == True

