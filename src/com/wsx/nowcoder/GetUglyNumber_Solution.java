package com.wsx.nowcoder;

import java.util.ArrayList;

public class GetUglyNumber_Solution {
    public static void main(String[] args) {
        final Solution502 solution502 = new Solution502();
        final int i = solution502.GetUglyNumber_Solution(5);
        System.out.println(i);
    }
}
class Solution502 {
    public int GetUglyNumber_Solution(int index) {
        if(index == 0){
            return -1;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(index == 1){
            return 1;
        }
        list.add(1);
        int i2 = 0, i3 = 0,i5 = 0;
        while(list.size() < index){
            int m2 = list.get(i2)*2;
            int m3 = list.get(i3)*3;
            int m5 = list.get(i5)*5;
            int min = Math.min(m2,Math.min(m3,m5));
            if(m2 == min){
                i2++;
            }
            if(m3 == min){
                i3++;
            }
            if(m5 == min){
                i5++;
            }

            list.add(min);
        }
        return list.get(list.size()-1);



    }
}
/*
class Solution502 {
    public int GetUglyNumber_Solution2(int n)
    {
        if(n<=0)return 0;
        ArrayList<Integer> list=new ArrayList<Integer>();
        list.add(1);
        int i2=0,i3=0,i5=0;
        while(list.size()<n)//循环的条件
        {
            int m2=list.get(i2)*2;
            int m3=list.get(i3)*3;
            int m5=list.get(i5)*5;
            int min=Math.min(m2,Math.min(m3,m5));
            list.add(min);
            if(min==m2)i2++;
            if(min==m3)i3++;
            if(min==m5)i5++;
        }
        return list.get(list.size()-1);
    }
}*/
