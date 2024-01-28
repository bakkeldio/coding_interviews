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
    fun reorderList(head: ListNode?): Unit {
        var slow = head

        var fast = head

        while(fast?.next != null){
            fast = fast.next?.next
            slow = slow?.next
        }

        var list1 = head
        var list2 = reverse(slow?.next)

        slow?.next = null
        var l2Next = list2?.next
        while (list2!=null){
            list2.next = list1?.next
            list1?.next = list2

            list1 = list2.next
            list2 = l2Next
            l2Next = list2?.next
        }


    }

    fun reverse(node: ListNode?): ListNode? {
        var current: ListNode? = node
        var next: ListNode? = current?.next
        var prev: ListNode? = null

        while(current != null) {
            current.next = prev
            prev = current
            current = next
            next = next?.next
        }
        return prev
    }
}