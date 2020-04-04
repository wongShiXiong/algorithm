package com.wsx.nowcoder;

import sun.security.util.AuthResources_it;

import java.util.Arrays;

public class FindInArray {
    public static void main(String[] args) {
       int [][] array1 ={{1,22}, {2,3}, {4,5}};
//       for(int i = 0; i <=array1.length;i++){
//           for (int j = 0 ;j<=array1[i].length;j++){
//               array1[i][j]=i*j;
//           }
//
//       }
        //System.out.println(Arrays.toString(array1));


        int target = 22;
        final Solution1 solution1 = new Solution1();
        final boolean find = solution1.Find(target, array1);
        System.out.println(find);
    }
}
class Solution1{
    public boolean Find(int target, int[][] array) {
        boolean isFind = false;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == target){
                    System.out.println("找到了"+target);
                    isFind = true;
                }

            }
        }
        return isFind;
    }
}