package Stacks;

import java.util.Stack;

public class QueueUsingTwoStacks {

    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public QueueUsingTwoStacks() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        if(s1.isEmpty() && !s2.isEmpty()) {
            s1 = getReverseOfS2();
        }
        s1.push(x);
    }

    public int pop() {
        if(s1.isEmpty() && s2.isEmpty()) return -1;
        if(!s2.isEmpty()) {
            return s2.pop();
        }
        return getReverseStack().pop();
    }

    public int peek() {
        if(s1.isEmpty() && s2.isEmpty()) return -1;
        if(!s2.isEmpty()) {
            return s2.peek();
        }
        return getReverseStack().peek();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    private Stack<Integer> getReverseStack() {
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        return s2;
    }

    private Stack<Integer> getReverseOfS2() {
        while(!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return s1;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */