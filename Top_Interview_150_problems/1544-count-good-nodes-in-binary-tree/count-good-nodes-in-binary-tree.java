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
        if (root == null) {
            return 0;
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, Integer.MIN_VALUE));
        int goodNodesCount = 0;

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            TreeNode node = current.node;
            int currentPathMax = current.pathMax;

            if (node.val >= currentPathMax) {
                goodNodesCount++;
            }

            if (node.left != null) {
                queue.offer(new Pair(node.left, Math.max(currentPathMax, node.val)));
            }
            if (node.right != null) {
                queue.offer(new Pair(node.right, Math.max(currentPathMax, node.val)));
            }
        }

        return goodNodesCount;
    }

    // Helper class to store node and path maximum value
    class Pair {
        TreeNode node;
        int pathMax;

        Pair(TreeNode node, int pathMax) {
            this.node = node;
            this.pathMax = pathMax;
        }
    }
}