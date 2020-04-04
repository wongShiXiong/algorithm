package com.wsx.nowcoder;

import com.sun.org.apache.xpath.internal.SourceTree;

public class FindGreatestSumOfSubArray {
    public static void main(String[] args) {
        int a[] = {6,-3,-2,7,-15,1,2,2};
        final Solution901 solution901 = new Solution901();
        final int i = solution901.FindGreatestSumOfSubArray(a);
        System.out.println(i);

    }
}
class Solution901 {
        public int FindGreatestSumOfSubArray(int[] array) {
            if(array.length == 0||array==null){
                return 0;
            }
            int sum = 0;
            int great = 0x80000000;
            for(int i = 0;i<array.length;i++){
                if(sum<=0){
                    sum = array[i];
                }else{
                    sum += array[i];
                }
                if(sum > great){
                    great = sum;
                }

            }
            return great;
        }

/*    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length==0 || array==null) {
            return 0;
        }
        int curSum=0;
        int greatestSum=0x80000000;
        for (int i = 0; i < array.length; i++) {
            if (curSum<=0) {
                curSum=array[i]; //记录当前最大值
            }else {
                curSum+=array[i]; //当array[i]为正数时，加上之前的最大值并更新最大值。
            }
            if (curSum>greatestSum) {
                greatestSum=curSum;
            }
        }
        return greatestSum;
    }*/
}