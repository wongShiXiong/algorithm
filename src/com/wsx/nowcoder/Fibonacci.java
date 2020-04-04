package com.wsx.nowcoder;

public class Fibonacci {
    public static void main(String[] args) {
        final Solution102 solution102 = new Solution102();
        final int i = solution102.Fibonacci(5);
        System.out.println(i);
    }
}
class Solution102 {
    public int Fibonacci(int n) {
        int Prepre = 0;
        int pre = 1;
        int result=0;
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        for(int i = 2; i<=n;i++){
            result = Prepre + pre;
            Prepre = pre;
            pre = result;
        }
        return result;
    }
}