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

/*
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxLevel = 0, maxSum = Integer.MIN_VALUE, level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSum = 0, size = queue.size();
            level++;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelSum += node.val;

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            if (levelSum > maxSum) {
                maxLevel = level;
                maxSum = levelSum;
            }
        }

        return maxLevel;
    }
    */
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        List<Integer> levelSums = new ArrayList<>(); // Store sums for each level
        calculateLevelSums(root, 1, levelSums);

        // Find the index of maximum sum and add 1 (since levels start from 1) 
        int maxLevelIndex = 0;
        for (int i = 1; i < levelSums.size(); i++) {
            if (levelSums.get(i) > levelSums.get(maxLevelIndex)) {
                maxLevelIndex = i;
            }
        }

        return maxLevelIndex + 1; 
    }

    private void calculateLevelSums(TreeNode node, int level, List<Integer> levelSums) {
        if (node == null) {
            return; 
        }

        // Resize if necessary (first time visiting this level)
        if (levelSums.size() < level) {
            levelSums.add(0);
        }

        levelSums.set(level - 1, levelSums.get(level - 1) + node.val);

        calculateLevelSums(node.left, level + 1, levelSums);
        calculateLevelSums(node.right, level + 1, levelSums);
    }
}