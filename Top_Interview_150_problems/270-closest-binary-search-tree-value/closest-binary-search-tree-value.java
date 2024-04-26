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
    
    

    public int closestValue(TreeNode root, double target) {
        return findClosestValue(root, target, root.val); // Start with root's value as initial closest
    }

    private int findClosestValue(TreeNode node, double target, int closest) {
        if (node == null) {
            return closest; // Reached the end
        }

        // Update closest if we're closer to the target 
        if (Math.abs(target - node.val) < Math.abs(target - closest)) {
            closest = node.val;
        } else if (Math.abs(node.val - target) == Math.abs(closest - target)){
            closest = Math.min(node.val, closest);
        }

        // Traverse the tree using BST properties
        if (target < node.val) {
            return findClosestValue(node.left, target, closest);
        } else {
            return findClosestValue(node.right, target, closest); 
        }
    }
}