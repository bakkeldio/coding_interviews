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
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        
        if (head == null || head?.next == null){
            return head
        }


        var dummy = head

        var prev: ListNode? = null

        var cur = dummy

        var l = left

        var r = right

        while(l > 1){
            prev = cur
            cur = cur?.next
            l--
            r--
        }

        var con = prev

        var tail = cur


        while(r > 0){

            val next = cur?.next

            cur?.next = prev
            prev = cur
            cur = next
            r--
        }


        if (con != null){
            con?.next = prev
        } else {
            dummy = prev
        }
        
        tail?.next = cur

        return dummy
        
    }
}