package com.wsx.nowcoder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class GetLeastNumbers_Solution {
    public static void main(String[] args) {
        int [] a ={1,5,3,6,7,8,4,2,9} ;
        final Solution702 solution702 = new Solution702();
        final ArrayList<Integer> integers = solution702.GetLeastNumbers_Solution(a, 3);
        System.out.println(integers);
    }
}
class Solution702{
        public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            if(input.length<k||k<0){
                return list;
            }
            PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k,new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2.compareTo(o1);
                }
            });

            for(int i=0;i<input.length;i++){
                if(queue.size()<k){
                    queue.offer(input[i]);
                }else if(queue.peek()>input[i]){
                    Integer temp = queue.poll();
                    temp = null;
                    queue.offer(input[i]);
                }

            }
            for(Integer a :queue){
                list.add(a);
            }
            return list;

        }

}
/*
class Solution702 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int length = input.length;
        if(k > length || k == 0){
            return result;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < length; i++) {
            if (maxHeap.size() != k) {
                maxHeap.offer(input[i]);
            } else if (maxHeap.peek() > input[i]) {
                Integer temp = maxHeap.poll();
                temp = null;
                maxHeap.offer(input[i]);
            }
        }
        for (Integer integer : maxHeap) {
            result.add(integer);
        }
        return result;
    }
}*/
