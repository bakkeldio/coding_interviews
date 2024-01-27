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
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {

        var list1S = list1

        var list2S = list2

        val list = ListNode(0)

        var prev = list

        while(list1S != null && list2S != null) {
            if (list1S.`val` > list2S.`val`){
                prev.next = list2S
                list2S = list2S.next
            } else if (list1S.`val` <= list2S.`val`){
                prev.next = list1S
                list1S = list1S.next
            }
            prev = prev.next
        }

        prev.next = list1S ?: list2S

        return list.next;
        
    }
}