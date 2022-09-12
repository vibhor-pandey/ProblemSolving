package LinkedList;

public class ReverseLinkedList_Recursive {
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode prev = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return prev;
    }

    public ListNode reverseListItr(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        if(head == null) return null;
        while(current.next != null) {
            prev = current;
            current = current.next;
            prev.next = current.next;
            current.next = head;
            head = current;
            current = prev;
        }
        return head;
    }

    public void print(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + ", ");
            curr = curr.next;
        }
        System.out.println();
    }
}
