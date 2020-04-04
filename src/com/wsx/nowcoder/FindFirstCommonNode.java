package com.wsx.nowcoder;

import com.wsx.ListNode;

public class FindFirstCommonNode {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode current1 = pHead1;
        ListNode current2 = pHead2;
        if(current1 == null || current2==null){
            return null;
        }
        int length1 = getLength(current1);
        int length2 = getLength(current2);

        if(length1>length2){
            int len = length1 - length2;
            while(len>0){
                current1 = current1.next;
                len--;
            }
        }else{
            int len = length2 - length1;
            while(len>0){
                current2 = current2.next;
                len--;
            }
        }
        while(current1 != current2){
            current1 = current1.next;
            current2 = current2.next;
        }
        return current1;
    }
    public int getLength(ListNode head){
        int length = 0;
        ListNode current = head;
        while(current != null){
            length++;
            current = current.next;
        }
        return length;
    }
}