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
   

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> result = new ArrayList<>(); 
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Math.abs(a - target) > Math.abs(b - target) ? -1: 1); 

        findClosestKValues(root, target, k, maxHeap);
        return new ArrayList<>(maxHeap); // Convert the heap to a list
    }

    private void findClosestKValues(TreeNode node, double target, int k, PriorityQueue<Integer> heap) {
        if (node == null) {
            return;
        }

        heap.add(node.val);

        // Maintain a max-heap of size k (prioritizing closest values)
        if (heap.size() > k) {
            heap.poll(); 
        }

        // Utilize BST properties to guide search
        findClosestKValues(node.left, target, k, heap);
        findClosestKValues(node.right, target, k, heap);
    }
}