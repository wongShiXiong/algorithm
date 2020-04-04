package com.wsx.nowcoder;

public class Sum_Solution {
    public static void main(String[] args) {
        final int i = Sum_Solution(3);
        System.out.println(i);
    }

    public static int Sum_Solution(int n) {
        int sum = n;
        Boolean tf = (n > 0 ) && ((sum +=Sum_Solution(n - 1)) > 0);
        return sum;
    }


}

class Solution304 {
    public int Sum_Solution(int n) {
        int sum = n;
        Boolean tf = (n > 0 ) && ((sum +=Sum_Solution(n - 1)) > 0);
        return sum;
    }
}



















/*    解题思路：
            1.需利用逻辑与的短路特性实现递归终止。 2.当n==0时，(n>0)&&((sum+=Sum_Solution(n-1))>0)只执行前面的判断，为false，然后直接返回0；
            3.当n>0时，执行sum+=Sum_Solution(n-1)，实现递归计算Sum_Solution(n)。*/
/*    public static int Sum_Solution(int n) {
        int sum = n;
        boolean ans = (n>0)&&((sum+=Sum_Solution(n-1))>0);
        return sum;
    }*/
