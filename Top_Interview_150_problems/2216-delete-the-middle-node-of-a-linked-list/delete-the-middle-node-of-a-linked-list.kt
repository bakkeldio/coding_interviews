/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun deleteMiddle(head: ListNode?): ListNode? {

        if (head?.next == null){
            return null
        }
        
        var prev = ListNode(0)

        prev.next = head

        var fast = head

        while(fast != null && fast?.next != null) {
            prev = prev.next
            fast = fast?.next?.next
        }

        prev?.next = prev?.next?.next

        return head
    }
}