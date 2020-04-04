package com.wsx.nowcoder;

import java.util.Stack;

public class MinStack {
}

class Solution505 {

    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();
    public void push(int node) {
        stack.push(node);
        if(minStack.isEmpty()){
            minStack.push(stack.peek());
        }
        else if(stack.peek() < minStack.peek()){
            minStack.push(node);
        }else{
            minStack.push(minStack.peek());//这里面存的是每次最小的值，而不是单纯的存值，先进后出。所以栈顶就是最小值
        }
    }

    public void pop() {
        stack.pop();//出栈时要保证最小栈依然是最小并且不影响最小栈有值而stack无此值，所以也要出栈
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
/*
class Solution505 {
        Stack<Integer> dataStack = new Stack<Integer>();
        Stack<Integer> minStack = new Stack<Integer>();

        public void push(int node) {
            dataStack.push(node);
            if(minStack.isEmpty() || node < minStack.peek()){
                minStack.push(node);
            }
            else{
                minStack.push(minStack.peek());
            }
        }

        public void pop() {
            dataStack.pop();
            minStack.pop();
        }

        public int top() {
            return dataStack.peek();
        }

        public int min() {
            return minStack.peek();
        }

}*/
