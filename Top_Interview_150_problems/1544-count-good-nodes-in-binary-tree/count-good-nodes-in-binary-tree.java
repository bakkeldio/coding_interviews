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

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, Integer.MIN_VALUE));
        
        int goodNodesCount = 0;

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> current = queue.poll();
            TreeNode node = current.key;
            int currentPathMax = current.value;

            if (node.val >= currentPathMax) {
                goodNodesCount++;
            }

            if (node.left != null) {
                queue.offer(new Pair<>(node.left, Math.max(currentPathMax, node.val)));
            }
            if (node.right != null) {
                queue.offer(new Pair<>(node.right, Math.max(currentPathMax, node.val)));
            }
        }

        return goodNodesCount;
    }
}

class Pair<U, V> {
    public U key;
    public V value;

    public Pair(U key, V value) {
        this.key = key;
        this.value = value;
    }
    // getters omitted for brevity
}