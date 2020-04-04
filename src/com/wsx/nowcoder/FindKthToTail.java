package com.wsx.nowcoder;

import com.wsx.ListNode;


public class FindKthToTail {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(8);
        ListNode node5 = new ListNode(10);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        final Solution103 solution103 = new Solution103();
        final ListNode listNode = solution103.FindKthToTail(head, 6);
        System.out.println(listNode.val);

    }
}
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
class Solution103 {
    public ListNode FindKthToTail(ListNode head, int k) {
        final int size = size(head);

        System.out.println(size);
        if (size - k < 0){
            return null;
        }else {
            for (int i = 0; i <= size - k -1; i++) {
                if (head != null) {
                    head = head.next;
                }

            }
            return head;
        }
    }

    public int size(ListNode head){
        int size =1;
        if(head != null){
            while(head.next != null){
                size++;
                head = head.next;
            }
        }
        return size;
    }
}








