package com.bear.queue;


import java.util.Scanner;

public class ArrayQueueDemo {
    //测试
    public static void main(String[] args) {
        final ArrayQueueList queue = new ArrayQueueList(3);
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

class ArrayQueueList{
    private int maxSize;
    private int front; //链表头
    private int rear;//链表尾
    private int[] arr;

    //构造器笔记
    //覆盖默认无参构造器，且与类名相同以及不能有返回值，void也不行
    public ArrayQueueList(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    public boolean isFull(){
        return rear == maxSize - 1;
    }

    public boolean isEmpty(){
        return rear == front;
    }

    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列已满，添加失败~");
            return;
        }
        rear++;//尾节点后移
        arr[rear] = n;
    }

    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，无法取数据");
        }
        front++;
        return arr[front];
    }

    public void showQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，无法取数据");
        }
        for (int i = 0; i<arr.length; i++){
            System.out.printf("arr[%d] = %d\n",i,arr[i]);
        }
    }

    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，无法取数据");
        }
        return arr[front+1];
    }




}