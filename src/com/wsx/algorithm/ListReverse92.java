package com.wsx.algorithm;

/**
 *
 */
public class ListReverse92 {
    public static void main(String[] args) {

    }
}
class Solution92{
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //定义一个初始为0的节点
        ListNode dummy  = new ListNode(0);

        ListNode pre = dummy;

        dummy =head;


        for (int i=1; i< m ;i++){
            pre=pre.next;
        }
        head=pre.next;

        for(int i =n;i < m; i++){
            ListNode new_node = head.next;

            head.next=new_node.next;

            new_node.next=pre.next;

            pre.next = new_node;

        }
        return dummy.next;
    }
}