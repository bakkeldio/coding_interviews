# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def verticalOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """

    def verticalOrder(self, root):
        if not root:
            return []


        columnTable = defaultdict(list)
        min_column = max_column = 0
        queue = deque([(root, 0)])


        while queue:
            node, column = queue.popleft()


            if node is not None:
                columnTable[column].append(node.val)
                min_column = min(min_column, column)
                max_column = max(max_column, column)


                queue.append((node.left, column - 1))
                queue.append((node.right, column + 1))


        return [columnTable[x] for x in range(min_column, max_column + 1)]    
        