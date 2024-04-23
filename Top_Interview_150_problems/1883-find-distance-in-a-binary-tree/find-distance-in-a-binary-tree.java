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
    public int findDistance(TreeNode root, int p, int q) {
        TreeNode lca = findLCA(root, p, q); // Find the Lowest Common Ancestor

        // Calculate distances from LCA to 'p' and 'q'
        int distP = findDepth(lca, p, 0);
        int distQ = findDepth(lca, q, 0);

        return distP + distQ;
    }

    // Function to find the Lowest Common Ancestor (LCA)
    private TreeNode findLCA(TreeNode node, int p, int q) {
        if (node == null || node.val == p || node.val == q) {
            return node;
        }

        TreeNode left = findLCA(node.left, p, q);
        TreeNode right = findLCA(node.right, p, q);

        if (left != null && right != null) {
            return node;  // Current node is the LCA
        }

        return left != null ? left : right;
    }

    // Function to find the depth of a node from a given ancestor
    private int findDepth(TreeNode ancestor, int target, int depth) {
        if (ancestor == null) {
            return -1;
        }
        if (ancestor.val == target) {
            return depth;
        }

        int leftDist = findDepth(ancestor.left, target, depth + 1);
        if (leftDist != -1) {
            return leftDist;
        }

        return findDepth(ancestor.right, target, depth + 1); 
    }
}