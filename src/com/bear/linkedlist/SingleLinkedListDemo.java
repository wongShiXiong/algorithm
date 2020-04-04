package com.bear.linkedlist;

import javax.print.attribute.standard.NumberUp;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();

//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero4);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);

        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);

        singleLinkedList.list();


        singleLinkedList.update(new HeroNode(1,"ss","aa"));

        System.out.println("修改后");

        singleLinkedList.list();


        System.out.println("删除后");

//        singleLinkedList.del(1);
//        singleLinkedList.del(2);
//        singleLinkedList.del(3);
//        singleLinkedList.del(4);

        singleLinkedList.list();

        //链表长度
        System.out.println("链表长度");
        System.out.println(SingleLinkedList.getLength(singleLinkedList.getHead()));

        System.out.println("_____________________________________");

        System.out.println(singleLinkedList.findLastIndexNode(singleLinkedList.getHead(),3));

        System.out.println("_____________________________________");
        SingleLinkedList.reverseList(singleLinkedList.getHead());
        singleLinkedList.list();

        System.out.println("_____________________________________");
        singleLinkedList.reversePrint(singleLinkedList.getHead());

    }



}

class SingleLinkedList{
    //头节点，不存放数据
    private HeroNode head = new HeroNode(0,"","");

    public HeroNode getHead() {
        return head;
    }

    public void add(HeroNode heroNode){
        HeroNode temp = head;

        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }

        temp.next = heroNode;


    }

    public void addByOrder(HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                break;
            }
            if(temp.next.no > heroNode.no){
                break;
            }else if (temp.next.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            System.out.printf("编号%d相同不能插入",heroNode.no);
        }else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    public void update(HeroNode newHeroNode){
        if (head.next == null){
            System.out.println("链表数据为空，无法修改数据");
            return;
        }

        HeroNode temp = head.next;
        boolean flag = false;

        while (true){
            if (temp == null){
                return;
            }

            if (temp.no == newHeroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;

        }
        if (flag){
            temp.name = newHeroNode.name;
            temp.nikename = newHeroNode.nikename;
        }else {
            System.out.println("没有找到匹配");
        }
    }

    public void del(int no){
        HeroNode temp = head;
        boolean flag = false;

        while (true){
            if (head.next == null){
                break;
            }
            if (temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag){
            temp.next = temp.next.next;
        }else {
            System.out.println("没找到");
        }
    }

    public void list(){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        //这个地方head也可以
        HeroNode temp = head.next;

        while (true){
            if (temp == null) {
                break;
            }

            System.out.println(temp);

            //当temp.next为null时，temp就被赋为null，则跳出循环
            temp = temp.next;
        }
    }

    public static int getLength(HeroNode head){
        if (head.next == null){
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while (cur != null){
            length++;
            cur = cur.next;
        }
        return length;
    }

    //2)	查找单链表中的倒数第 k 个结点 【新浪面试题】
    public HeroNode findLastIndexNode(HeroNode head,int index){
        if (head.next == null){
            return null;
        }

        int size = getLength(head);


        if (index <= 0 || index > size){
            return null;
        }

        HeroNode cur = head.next;

        for (int i = 0; i < size - index; i++){
            cur = cur.next;
        }
        return cur;
    }

    //3)	单链表的反转【腾讯面试题，有点难度】
    public static void reverseList(HeroNode head){
        if (head.next == null || head.next.next == null){
            return;
        }
        HeroNode cur = head.next;
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0,"","");

        //有点绕，第二句是head.next.next指向reverse的下一个地址，也就是把老链表的节点取出放入新链表的下一个位置
        //但是还没有连接，需要再将新链表的next指向新节点（也就是head.next）cur;
        while (cur != null){
            next = cur.next;

            //二三句的顺序也不能变，好好想想

            //让旧链表节点指向新链表头节点的下一个链表
            cur.next = reverseHead.next;

            //让reverseHead和新的节点连接起来
            reverseHead.next = cur;

            cur  = next;
        }
        head.next = reverseHead.next;

    }

    //4)	从尾到头打印单链表 【百度，要求方式 1：反向遍历 。 方式 2：Stack 栈】
    public void reversePrint(HeroNode head){
        if (head.next == null){
            return;
        }
        HeroNode cur = head.next;
        final Stack<HeroNode> stack = new Stack<HeroNode>();

        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }

        while (stack.size() > 0){
            System.out.println(stack.pop());
        }
    }

    //5)	合并两个有序的单链表，合并之后的链表依然有序【课后练习.】

    public void addTwoLinked(HeroNode head1,HeroNode head2){

    }

}

class HeroNode{
    public int no;
    public String name;
    public String nikename;
    public HeroNode next;

    public HeroNode(int no, String name, String nikename) {
        this.no = no;
        this.name = name;
        this.nikename = nikename;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nikename='" + nikename + '\'' +
                '}';
    }
}
