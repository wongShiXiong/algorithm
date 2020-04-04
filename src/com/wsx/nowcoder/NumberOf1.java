package com.wsx.nowcoder;

public class NumberOf1 {
    public static void main(String[] args) {

    }
}
class Solution601{
    public int NumberOf1(int n) {
        int count = 0;
        int i = 1;
        while(i!=0){
            if((i & n) != 0){
                count++;
            }
            i = i<<1;
        }
        return count;
    }
}
