package com.offer;

import java.util.Scanner;

public class njc {
    public static int testJc(int n) {
        //递归终止条件
        if (n < 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return n * testJc(n-1);
    }
    public static void main(String[] args) {
        boolean flag = true;
        int n = 0;
        while (flag){
            Scanner in =new Scanner(System.in);
            try {
                n = in.nextInt();
                flag = false;
            } catch (Exception e) {
                System.out.println("输入格式错误，请从新输入");
            }
        }

        System.out.println(testJc(n));
        //测试结果 输入 输出
        //          3    6
        //          -1    0
        //          0     0
        //          1     1
        //   字符串或其他  从新输入
    }
}
