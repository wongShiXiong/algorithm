package com.bear.queue;

import javax.swing.*;
import java.util.Scanner;

public class CircleArrayQueueDemo {
    //测试
    public static void main(String[] args) {
        final CircleArray queue = new CircleArray(4);
        char key = ' ';//接收用户输入
        Scanner scanner =new Scanner(System.in);
        boolean loop = true;
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头的数据");
            key = scanner.next().charAt(0);//接受字符

            switch (key){
                case 's':
                    try {
                        queue.showQueue();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'a':
                    System.out.println("输入一个数：");
                    int i = scanner.nextInt();
                    queue.addQueue(i);
                    break;
                case 'g':
                    try {
                        final int res = queue.getQueue();
                        System.out.printf("取出的数据是：%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());//getQueue里面的异常信息
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是：%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());//里面的异常信息
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

class CircleArray {
    private int maxSize;
    private int front; //链表头
    private int rear;//链表尾
    private int[] arr;

    public CircleArray(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    //判断队列是否为满
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }



    public void addQueue(int n){
        //先判断队列是否为满
        if(isFull()){
            System.out.println("队列为满，无法添加数据");
            return;
        }
        //直接加入数据
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，无法取数据");
        }
        //把头值保存
        int value = arr[front];
        //后移
        front = (front + 1) % maxSize;
        return value;
    }

    public void showQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，无法取数据");
        }
        //从front开始遍历

        for (int i = front; i<front + size(); i++){
            System.out.printf("arr[%d] = %d\n",i % maxSize,arr[i % maxSize]);
        }
    }

    public int size(){
        return (rear + maxSize - front) % maxSize;
    }


    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，无法取数据");
        }
        return arr[front];
    }


}