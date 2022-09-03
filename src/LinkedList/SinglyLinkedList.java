package LinkedList;

public class SinglyLinkedList {

    public ListNode head;
    public ListNode tail;

    public SinglyLinkedList() {
        head = null;
    }

    public int get(int index) {
        if (head == null) {
            return -1;
        }
        else {
            ListNode current = head;
            while (index > 0 && current != null) {
                current = current.next;
                index--;
            }
            return current != null ? current.value : -1;
        }
    }

    public void addAtHead(int val) {
        if (head == null) {
            head = new ListNode(val);
            tail = head;
        }
        else {
            ListNode newHead = new ListNode(val);
            newHead.next = head;
            head = newHead;
        }
    }

    public void addAtTail(int val) {
        ListNode node = new ListNode(val);
        if (head == null) {
            head = node;
            return;
        }
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = node;
    }

    public void addAtIndex(int index, int val) {
        if (head == null && index == 0) {
            head = new ListNode(val);
            return;
        }
        ListNode current = head;
        ListNode node = new ListNode(val);
        if (index == 0) {
            node.next = head;
            head = node;
            return;
        }
        while (index > 1) {
            current = current.next;
            index--;
        }
        if (current != null) {
            node.next = current.next;
            current.next = node;
        }
    }

    public void deleteAtIndex(int index) {
        if (head == null) {
            return;
        }
        ListNode current = head;
        if (index == 0) {
            head = head.next;
            return;
        }
        while (index > 1) {
            current = current.next;
            index--;
        }
        if (current != null && current.next != null) {current.next = current.next.next;}
    }

    public void print(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.value + ", ");
            curr = curr.next;
        }
        System.out.println();
    }
    /**
     * Your MyLinkedList object will be instantiated and called as such:
     * MyLinkedList obj = new MyLinkedList();
     * int param_1 = obj.get(index);
     * obj.addAtHead(val);
     * obj.addAtTail(val);
     * obj.addAtIndex(index,val);
     * obj.deleteAtIndex(index);
     */
}
class ListNode {
    Integer value;
    ListNode next;

    public ListNode(Integer value) {
        this.value = value;
        this.next = null;
    }
}
