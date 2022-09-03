package LinkedList;

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
class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        int index = 0;
        while(current != null) {
            current = current.next;
            index++;
        }
        if(n > index) return null;
        index = index - n;
        if(index == 0) {
            return head.next;
        }

        current = head;
        while(index > 1) {
            current = current.next;
            index--;
        }
        ListNode nthNode = current.next;
        if(current.next != null) {
            current.next = current.next.next;
        } else {
            current.next = null;
        }
        return head;
    }
}
