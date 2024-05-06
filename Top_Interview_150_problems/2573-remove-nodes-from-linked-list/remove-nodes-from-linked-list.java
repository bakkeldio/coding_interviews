/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNodes(ListNode head) {

        Stack<Integer> stack = new Stack<>();
        ListNode node = head;
        while(node != null){
            stack.push(node.val);
            node = node.next;
        }
        
        int maxSoFar = stack.pop();
        ListNode next = new ListNode(maxSoFar);

        while(!stack.isEmpty()){
            int n = stack.pop();
            if (n < maxSoFar){
                continue;
            } else {
                ListNode newNode = new ListNode(n);
                newNode.next = next;
                next = newNode;
                maxSoFar = n;
            }
        }

        return next;

    }
}