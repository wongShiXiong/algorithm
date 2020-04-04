package com.wsx.nowcoder;

import java.util.Stack;

public class IsPopOrder {
    public static void main(String[] args) {
        int [] a = {1,2,3,4,5};
        int [] b = {4,5,3,2,1};
        final Solution301 solution301 = new Solution301();
        final boolean b1 = solution301.IsPopOrder(a, b);
        System.out.println(b1);
    }
}

class Solution301 {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA.length == 0 || popA.length == 0) {
            return false;
        }
        final Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && (stack.peek() == popA[index])) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }
}
