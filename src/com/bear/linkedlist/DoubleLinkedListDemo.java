package com.bear.linkedlist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

        final DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();


        doubleLinkedList.update(new HeroNode2(1,"1","1"));

        System.out.println("-----------------");
        doubleLinkedList.list();
        System.out.println("-----------------");

        doubleLinkedList.del(4);
        System.out.println("-----------------");
        doubleLinkedList.list();
    }


}

class DoubleLinkedList{
    //头节点，不存放数据
    private HeroNode2 head = new HeroNode2(0,"","");

    public HeroNode2 getHead() {
        return head;
    }

    public void add(HeroNode2 heroNode){
        HeroNode2 temp = head;

        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }

        temp.next = heroNode;
        heroNode.pre = temp;


    }

    public void update(HeroNode2 newHeroNode){
        if (head.next == null){
            System.out.println("链表数据为空，无法修改数据");
            return;
        }

        HeroNode2 temp = head.next;
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
        if (head.next == null){
            System.out.println("链表数据为空，无法修改数据");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;

        while (true){
            if (temp == null){
                break;
            }
            if (temp.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag){
            temp.pre.next = temp.next;
            if (temp.next != null){
                temp.next.pre = temp.pre;
            }

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
        HeroNode2 temp = head.next;

        while (true){
            if (temp == null) {
                break;
            }

            System.out.println(temp);

            //当temp.next为null时，temp就被赋为null，则跳出循环
            temp = temp.next;
        }
    }
    //双向链表的第二种添加方式,按照编号顺序 [示意图]按照单链表的顺序添加，稍作修改即可
    public void addByOrder(){

    }
}

class HeroNode2{
    public int no;
    public String name;
    public String nikename;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nikename) {
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