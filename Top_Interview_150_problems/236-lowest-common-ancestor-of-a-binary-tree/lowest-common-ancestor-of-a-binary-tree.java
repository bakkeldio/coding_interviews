/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null) {
            return null;
        }
        
        // If both a and b are on the left subtree, then the LCA must be on the left subtree.
        if (isDescendant(root.left, a) && isDescendant(root.left, b)) {
            return lowestCommonAncestor(root.left, a, b);
        }
        
        // If both a and b are on the right subtree, then the LCA must be on the right subtree.
        if (isDescendant(root.right, a) && isDescendant(root.right, b)) {
            return lowestCommonAncestor(root.right, a, b);
        }
        
        // If a and b are different and present in the left and right subtrees respectively, then root is the LCA.
        return root;
    }
    
    public boolean isDescendant(TreeNode root, TreeNode node) {
        if (root == null) {
            return false;
        }
        
        if (root == node) {
            return true;
        }
        
        return isDescendant(root.left, node) || isDescendant(root.right, node);
    }
}