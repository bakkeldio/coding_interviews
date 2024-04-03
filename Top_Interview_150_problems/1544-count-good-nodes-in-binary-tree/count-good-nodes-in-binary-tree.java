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
        return goodNodesHelper(root, Integer.MIN_VALUE);
    }

    private int goodNodesHelper(TreeNode node, int currentPathMax) {
        if (node == null) {
            return 0;
        }

        int goodNodesCount = node.val >= currentPathMax ? 1 : 0;
        goodNodesCount += goodNodesHelper(node.left, Math.max(currentPathMax, node.val));
        goodNodesCount += goodNodesHelper(node.right, Math.max(currentPathMax, node.val));

        return goodNodesCount;
    }
}