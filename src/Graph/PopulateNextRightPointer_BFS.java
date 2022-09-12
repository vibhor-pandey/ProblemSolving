package Graph;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class PopulateNextRightPointer_BFS {
    public Node connect(Node root) {
        if(root == null) return root;
        bfs(root);
        return root;
    }

    private void bfs(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        Node prev = null;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Node current = q.poll();
                if(i < size - 1) current.next = q.peek();
                if(current.left != null) q.add(current.left);
                if(current.right != null) q.add(current.right);
            }
        }
    }
}
