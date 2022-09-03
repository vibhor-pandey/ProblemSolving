package LinkedList;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class CycleInLinkedList {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slowPointer = head;
        ListNode fastPointer = head.next;
        while(slowPointer != fastPointer && fastPointer != null && slowPointer != null) {
            slowPointer = slowPointer.next;
            if(fastPointer.next != null) {
                fastPointer = fastPointer.next.next;
            } else {
                return false;
            }
        }
        if(slowPointer == fastPointer) return true;
        else return false;
    }
}