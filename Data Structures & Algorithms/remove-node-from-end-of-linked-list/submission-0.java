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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;

        ListNode ptr = head;
        while(ptr != null){
            ptr = ptr.next;
            size++;
        }
        int count = 0;
        int removeIndex = size-n;
        if(removeIndex == 0){
            return head.next;
        }
        ptr = head;
        for(int i = 0; i< size-1;i++){
            if((i + 1) == removeIndex){
                ptr.next = ptr.next.next;
                break;
            }
            ptr = ptr.next;
        }
        return head;
    }
}
