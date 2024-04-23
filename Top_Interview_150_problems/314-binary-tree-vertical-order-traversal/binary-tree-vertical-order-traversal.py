# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalOrder(self, root: Optional[TreeNode]) -> List[List[int]]:

        if not root:
            return []


        columnTable = defaultdict(list)
        min_column = max_column = 0


        def dfs(node, column, row):
            nonlocal min_column, max_column
            if node is not None:
                columnTable[column].append((row, node.val))
                min_column = min(min_column, column)
                max_column = max(max_column, column)


                dfs(node.left, column - 1, row + 1)
                dfs(node.right, column + 1, row + 1)


        dfs(root, 0, 0)


        result = []
        for i in range(min_column, max_column + 1):
            columnTable[i].sort(key=lambda x: x[0])
            result.append([val for row, val in columnTable[i]])


        return result    
        