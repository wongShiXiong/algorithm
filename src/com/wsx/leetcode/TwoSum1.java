package com.wsx.leetcode;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

    你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

    示例:

    给定 nums = [2, 7, 11, 15], target = 9

    因为 nums[0] + nums[1] = 2 + 7 = 9
    所以返回 [0, 1]
 */

public class TwoSum1 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        TwoSum1 sum1 = new TwoSum1();
        int[] res = sum1.twoSum(nums, target);

        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }




    public int[] twoSum(int[] nums, int target) {
        int [] res = new int[2];
        if(nums == null || nums.length <= 0){
            return res;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        //val=target-nums[i];

        for(int i = 0; i<=nums.length; i++){
            int num = nums[i];
            int val = target - num;
            if (map.containsKey(val)){
                res[0] = map.get(val);
                //键是num 值是下标
                res[1] = i;//返回的是下标，val是key键  val是num
                return res;
            }else map.put(num,i);
        }
        return res;
    }
}
