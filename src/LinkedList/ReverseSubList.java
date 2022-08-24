package LinkedList;

/**
 * Given the head of a singly linked list and two integers left and right where left <= right,
 * reverse the nodes of the list from position left to position right, and return the reversed list.
 *
 *
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 * Example 2:
 *
 * Input: head = [5], left = 1, right = 1
 * Output: [5]
 */

//Definition for singly-linked list.
class ListNode {
int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class ReverseSubList {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //1) Get the left & right position
        //2) Reverse the sub-list
        //3) Final connection between tail & sub-list head
        if(head == null) return null;
        if(head.next == null) return head;

        //1) Get the Node @ left
        ListNode current = head, prev = null, tail = null, con = null;
        while(left > 1) {
            prev = current;
            current = current.next;
            left--;
            right--;
        }
        tail = current;
        con = prev;

        //2) Reverse the sub-list
        ListNode third = null;
        while(right > 0) {
            third = current.next;
            current.next = prev;
            prev = current;
            current = third;
            right--;
        }

        //3) Final connection
        if(con != null) {
            con.next = prev;
        } else {
            head = prev;
        }
        tail.next = current;

        return head;
    }
}
