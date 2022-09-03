package Stacks;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Implement the MinStack class:
 *
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * You must implement a solution with O(1) time complexity for each function.
 */

import java.util.ArrayList;
import java.util.List;

public class GetMinOperationStack {

    private List<Integer> list;
    private List<Integer> min;

    public GetMinOperationStack() {
        list = new ArrayList<>();
        min = new ArrayList<>();
    }

    public void push(int val) {
        if(list.size() == 0) {
            min.add(val);
        }
        list.add(val);
        if(val <= min.get(min.size() - 1)) {
            min.add(val);
        }
    }

    public void pop() {
        if(!list.isEmpty()) {
            int num = list.remove(list.size() - 1);
            if(min.get(min.size() - 1) == num) {
                min.remove(min.size() - 1);
            }
        }
    }

    public int top() {
        if(!list.isEmpty()) {
            return list.get(list.size() - 1);
        }
        return -1;
    }

    public int getMin() {
        if(!min.isEmpty()) {
            return min.get(min.size() - 1);
        }
        return -1;
    }

    private void print(String operation, List<Integer> l) {
        System.out.print(operation + ": ");
        for(int num : l) {
            System.out.print(num + ", ");
        }
        System.out.println();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
