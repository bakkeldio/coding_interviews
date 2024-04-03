/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int goodNodes(TreeNode root) {
        return countGoodNodes(root, Integer.MIN_VALUE); 
    }

    private int countGoodNodes(TreeNode node, int maxSoFar) {
        if (node == null) {
            return 0; // Base case: empty node
        }

        int result = node.val >= maxSoFar ? 1 : 0; // Is this node good?
        maxSoFar = Math.max(maxSoFar, node.val);  // Update maximum for children

        // Recursively explore left and right subtrees
        result += countGoodNodes(node.left, maxSoFar);
        result += countGoodNodes(node.right, maxSoFar);

        return result;
    }
}