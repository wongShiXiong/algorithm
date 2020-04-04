package com.wsx.nowcoder;

import com.wsx.ListNode;

import java.util.ArrayList;
import java.util.Stack;

public class PrintListFromTailToHead {
    public static void main(String[] args) {

    }
}
class Solution23{
    /**
     *    public class ListNode {
     *        int val;
     *        ListNode next = null;
     *
     *        ListNode(int val) {
     *            this.val = val;
     *        }
     *    }
     *
     */
    public class Solution {
        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            ArrayList<Integer> arr = new ArrayList();
            if(listNode == null){
                return null;
            }
            Stack<Integer> stack = new Stack<>();
            ListNode cur = listNode;
            while(cur.next != null){
                stack.push(cur.val);
                cur = cur.next;
            }
            while(stack.size()>0){
                arr.add(stack.pop());
            }
            return arr;

        }
    }
}