package com.wsx.nowcoder;

public class MoreThanHalfNum_Solution {
    public static void main(String[] args) {
        int a [] ={4,2,4,1,4,2};
        final Solution705 solution705 = new Solution705();
        final int i = solution705.MoreThanHalfNum_Solution(a);
        System.out.println("超过一半的数字:"+i);
    }
}
/*


采用阵地攻守的思想：
第一个数字作为第一个士兵，守阵地；count = 1；
遇到相同元素，count++;
遇到不相同元素，即为敌人，同归于尽,count--；当遇到count为0的情况，又以新的i值作为守阵地的士兵，
继续下去，到最后还留在阵地上的士兵，有可能是主元素。
再加一次循环，记录这个士兵的个数看是否大于数组一般即可。
*/
class Solution705{
        public int MoreThanHalfNum_Solution(int [] array) {
            if(array.length == 0 || array == null){
                return 0;
            }
            int result = array[0];
            int times = 1;
            for(int i = 1; i < array.length; i++){
                if(times == 0) {
                    result = array[i];
                    times = 1;
                }else {
                    if (result == array[i]) {
                        times++;
                    } else {
                        times--;
                    }
                }
            }
            times = 0;
            for(int i = 0;i < array.length;i++){
                if(result == array[i]){
                    times++;
                }
            }

            if(times*2<=array.length){
                result = 0;
            }
            return result;

        }

    /*public int MoreThanHalfNum_Solution(int [] array) {
        int length=array.length;
        if(array==null||length<=0){
            return 0;
        }

        int result=array[0];
        int times=1;
        for(int i=1;i<length;i++){
            if(times==0){
                result=array[i];
                times=1;
            }else{
                if(array[i]==result){
                    times++;
                }else{
                    times--;
                }
            }
        }

        times=0;
        for(int i=0;i<length;i++){
            if(result==array[i]){
                times++;
            }
        }

        if(times*2<length){
            result=0;
        }
        return result;
    }*/
}













/*采用用户“分形叶”思路（注意到目标数 超过数组长度的一半，对数组同时去掉两个不同的数字，到最后剩下的一个数就是该数字。
如果剩下两个，那么这两个也是一样的，就是结果），在其基础上把最后剩下的一个数字或者两个回到原来数组中，将数组遍历一遍统计一下数字出现次数进行最终判断
*/
/*
class Solution705 {
    public int MoreThanHalfNum_Solution(int [] array) {
        int length=array.length;
        if(array==null||length<=0){
            return 0;
        }

        if(length==1){
            return array[1];
        }

        int[] tempArray=new int[length];
        for(int i=0;i<length;i++){
            tempArray[i]=array[i];
        }

        for(int i=0;i<length;i++){
            //后面需要用零来代表抹除数字，所以对0时做特殊处理
            if(tempArray[i]==0){
                continue;
            }

            for(int j=i+1;j<length;j++){
                if(tempArray[i]!=tempArray[j]&&tempArray[j]!=0){
                    tempArray[i]=0;//此处用0代表抹去该数字
                    tempArray[j]=0;
                    break;
                }

            }
        }

        for(int i=0;i<length;i++){
            System.out.println(tempArray[i]);
        }

        //找出未被抹去的数字
        int result=0;
        for(int i=0;i<length;i++){
            if(tempArray[i]!=0){
                result=tempArray[i];
                break;
            }
        }

        int times=0;
        for(int i=0;i<length;i++){
            if(result==array[i]){

                times++;
            }
        }

        if(times*2<length){
            result=0;
        }
        return result;
    }
}*/
