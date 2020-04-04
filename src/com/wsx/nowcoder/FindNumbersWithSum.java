package com.wsx.nowcoder;

import java.util.ArrayList;

public class FindNumbersWithSum {
    /*
    不要被题目误导了！证明如下，清晰明了：
//输出两个数的乘积最小的。这句话的理解？
假设：若b>a,且存在，
a + b = s;
(a - m ) + (b + m) = s
则：(a - m )(b + m)=ab - (b-a)m - m*m < ab；说明外层的乘积更小
也就是说依然是左右夹逼法！！！只需要2个指针
1.left开头，right指向结尾
2.如果和小于sum，说明太小了，left右移寻找更大的数
3.如果和大于sum，说明太大了，right左移寻找更小的数
4.和相等，把left和right的数返回
 public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if (array == null || array.length == 0)
            return list;
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int total = array[left] + array[right];
            if (total == sum) {
                list.add(array[left]);
                list.add(array[right]);
                return list;
            } else if (total > sum) {
              //大于sum，说明太大了，right左移寻找更小的数
                --right;

            } else {
              //2.如果和小于sum，说明太小了，left右移寻找更大的数
                ++left;
            }
        }
        return list;
    }

    * */








}
class Solution303 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        //左右夹逼
        ArrayList<Integer> list = new ArrayList();
        if(array.length == 0 || array == null){
            return list;
        }
        int left = 0;
        int right = array.length - 1;
        while(left < right){
            int result = array[left] + array[right];
            if(result == sum){
                list.add(array[left]);
                list.add(array[right]);
                return list;
            }else if(result < sum){
                ++left;
            }else{
                --right;
            }
        }
        return list;
    }
}