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
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {

        if (head?.next == null && n == 1){
            return null
        }
        
        var prev = head

        var curr = head

        var count = 0


        while(curr != null){
            curr = curr?.next
            count++
        }

        var k = count - n

        var c = 0

        if (k == 0){
            return head?.next
        }

        while(prev != null && prev?.next != null){
            if (k - 1 == c) {
                prev?.next = prev?.next?.next
                return head
            }
            prev = prev?.next
            c++
        }

        return head
    }
}