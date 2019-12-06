package com.wsx.algorithm;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ListReverse {
    public static void main(String[] args) {

    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x)
    {
        val = x;
    }
 }
class solution{
    public ListNode reverseList(ListNode head) {
        //新链表指针指向空
        ListNode new_head = null;
        //旧链表指针指向头部
        ListNode old_head = head;
        //old_head不等于null为止也就是说旧链表移除到空则停止完成逆序
        while (old_head != null){
            //暂存结点，备份
            ListNode nextTemp = old_head.next;
            //把旧的链表第一个指针域指向新链表的null
            old_head.next = new_head;
            //新链表归位指向老的head
            new_head = old_head;
            //旧链表归为也就是head指向备份的next
            old_head = nextTemp;
        }
        return new_head;
    }
}
