package com.wsx.nowcoder;

public class duplicate {
}
class Solution888{
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(length==0){
            return false;
        }
        int a[]= new int[length];
        for(int i:numbers){
            a[i]++;
            if(a[i]>1){
                duplication[0] = a[i];
                return true;
            }
        }
        return false;
    }
}