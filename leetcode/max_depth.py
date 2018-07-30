# maximum depth of a binary tree

class TreeNode(object):
    def __init__(self,x):
        self.val = x
        self.left = None
        self.right = None

def max_depth(root):
    if root is None:
        return 0
    l_depth = max_depth(root.left)
    r_depth = max_depth(root.right)
    if l_depth > r_depth:
        return l_depth+1
    else:
        return r_depth+1