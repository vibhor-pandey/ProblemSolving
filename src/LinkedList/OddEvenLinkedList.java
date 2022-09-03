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
class OddEvenLinkedList {
    //1 -> 3 -> 5 -> 2 -> 4
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode currentOdd = head;
        ListNode evenHead = currentOdd.next;
        ListNode currentEven = evenHead;
        while(currentEven != null && currentEven.next != null) {
            currentOdd.next = currentEven.next;
            currentOdd = currentOdd.next;
            currentEven.next = currentOdd.next;
            currentEven = currentEven.next;
        }
        currentOdd.next = evenHead;
        return head;
    }
}
