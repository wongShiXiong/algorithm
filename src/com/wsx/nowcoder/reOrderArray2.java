package com.wsx.nowcoder;

public class reOrderArray2 {
    public static void main(String[] args) {
        int a[] = {1,2,10,3,5,4,8,6,9};
        final Solution701 solution701 = new Solution701();
        solution701.reOrderArray2(a);
        for (int e : a){
            System.out.println(e);
        }
    }
}
class Solution701 {
    public void reOrderArray2(int [] array) {
        int i = 0,j;
        if(array.length==0||array==null){
            return;
        }
        while(i<array.length){
            while(i<array.length&&!TrueOrFalse(array[i])){
                i++;
            }
            j = i + 1;
            while(j<array.length&&TrueOrFalse(array[j])){
                j++;
            }
            if(j<array.length){
                int temp = array[j];//存 偶数后的 第一个奇数
                for(int j2 = j-1; j2 >= i; j2--){
                    array[j2+1] = array[j2];//把偶数赋给奇数，也就是把前面的赋到后面的
                }
                array[i++] = temp;
            }else{
                break;
            }

        }
    }
    public boolean TrueOrFalse(int i){
        if(i%2==0){
            return true;
        }else{
            return false;
        }
    }
}
/*
class Solution701{
    */
/**
     * 1.要想保证原有次序，则只能顺次移动或相邻交换。
     * 2.i从左向右遍历，找到第一个偶数。
     * 3.j从i+1开始向后找，直到找到第一个奇数。
     * 4.将[i,...,j-1]的元素整体后移一位，最后将找到的奇数放入i位置，然后i++。
     * 5.終止條件：j向後遍歷查找失敗。
     *//*

    public void reOrderArray2(int [] a) {
        if(a==null||a.length==0)
            return;
        int i = 0,j;
        while(i<a.length){
            while(i<a.length&&!isEven(a[i]))//记到第一个偶数的位置，再记到第二个偶数的位置，然后用找到的奇数从最后一个开始替换，最后再把a【i】值赋值为奇数
                i++;//这句是只要是true就一直循环，也就是说奇数一直存在，就一直后移，知道i++不是奇数，那肯定是偶数
            j = i+1;//j就是下个偶数，也就是如上所说的第一个偶数的位置，i是第一个偶数的位置，一会儿要存放偶数序列（序列意思是可能就一个偶数或者多个连续的偶数）的后的第一个奇数
            while(j<a.length&&isEven(a[j]))//
                j++;
            if(j<a.length){
                int tmp = a[j];
                for (int j2 = j-1; j2 >=i; j2--) {
                    a[j2+1] = a[j2];
                }
                a[i++] = tmp;//i是第一个偶数的位置，一会儿要存放偶数序列（序列意思是可能就一个偶数或者多个连续的偶数）的后的第一个奇数也就是temp
            }else{// 查找失敗
                break;
            }
        }
    }
    boolean isEven(int n){
        if(n%2==0)
            return true;
        return false;
    }
}*/
