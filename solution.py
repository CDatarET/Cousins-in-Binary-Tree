# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def depth(self, root, f):
        if not root: return -1
        if root.val == f: return 0

        ld = self.depth(root.left, f)
        if ld != -1: return ld + 1

        rd = self.depth(root.right, f)
        if rd != -1: return rd + 1

        return -1

    def checkLineage(self, root, x, y, c):
        if not root or not c[0]: return

        if root.left and root.right:
            if (root.left.val == x and root.right.val == y) or (root.left.val == y and root.right.val == x):
                c[0] = False
                return
        
        self.checkLineage(root.left, x, y, c)
        self.checkLineage(root.right, x, y, c)

    def isCousins(self, root, x, y):
        xd = self.depth(root, x)
        yd = self.depth(root, y)

        if xd == yd:
            c = [True]
            self.checkLineage(root, x, y, c)
            return(c[0])
        else: return(False)
