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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
    //slow will be on middle , reverse the entire list after the slow ptr.

        ListNode list2 = slow.next;
        ListNode prev =  slow.next = null;
        while(list2 != null){
            ListNode tmp = list2.next;
            list2.next = prev;
            prev = list2;
            list2 = tmp;

        }

        ListNode first = head;
        ListNode second = prev;

        while(second != null){
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }
    }
}
