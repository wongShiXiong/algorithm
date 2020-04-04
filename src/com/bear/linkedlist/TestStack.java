package com.bear.linkedlist;

import java.util.Stack;

public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack();

        stack.add("111");
        stack.add("222");
        stack.add("333");

        while (stack.size() > 0){
            System.out.println(stack.pop());
        }

    }

}
