package LinkedList;

/**
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
 * If the two linked lists have no intersection at all, return null.
 *
 * For example, the following two linked lists begin to intersect at node c1:
 *
 *
 * The test cases are generated such that there are no cycles anywhere in the entire linked structure.
 *
 * Note that the linked lists must retain their original structure after the function returns.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class IntersectionPoint {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode prevB = headB;
        ListNode prevA = headA;

        while(prevA != prevB) {
            prevA = prevA == null ? headA : prevA.next;
            prevB = prevB == null ? headB : prevB.next;
        }
        return prevA;
    }
}