package com.bear.linkedlist;

public class Josephu {
    public static void main(String[] args) {
        final CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();
    }
}

class CircleSingleLinkedList{
    //first指针不能移动
    private Boy first = null;

    //添加所有孩子结点
    public void addBoy(int nums){
        if (nums < 1){
            System.out.println("输入值不正确");
        }
        //由于first不能移动所以需要一个辅助指针遍历
        Boy curBoy = null;
        //遍历添加孩子结点
        for (int i = 1; i <= nums; i++){
            //初始化孩子结点
            Boy boy = new Boy(i);
            if (i == 1){
                //first代表第一个结点的位置，不能动，创建第一个结点时需要头结点是自己
                //且自己的next也指向自己，也就是构成了环形链表
                first = boy;
                first.setNext(first);
                curBoy = first;
            }else {
                //这个地方是用curBoy指针添加新的Boy结点
                curBoy.setNext(boy);//此时i已经大于1，且为新结点
                boy.setNext(first);//将新结点的next指向链表头，也就是first结点
                curBoy = boy;//然后使curBoy结点后移
            }
        }


    }

    public void showBoy(){
        if (first == null){
            System.out.println("没有节点");
            return;
        }
        Boy curBoy = first;

        while (true){
            System.out.printf("编号%d \n",curBoy.getNo());
            if (curBoy.getNext() == first){
                break;
            }
            curBoy = curBoy.getNext();

        }
    }

    public void countBoy(int startNo,int countNum,int nums){
        if (first == null || startNo < 1 || startNo > nums){
            System.out.println("输入有误");
            return;
        }


    }
}

class Boy{
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
