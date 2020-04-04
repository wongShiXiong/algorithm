package com.wsx.nowcoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrintMinNumber {
    public static void main(String[] args) {
        int n [] = {3456,32,321467};
        final String s = Solution503.PrintMinNumber(n);
        System.out.println(s);
    }
}

class Solution503 {
    public static String PrintMinNumber(int [] numbers) {
        String s ="";
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0;i<numbers.length;i++){
            list.add(numbers[i]);
        }
        Collections.sort(list,new Comparator<Integer>(){
            public int compare(Integer str1,Integer str2){
                String s1 = str1 +""+ str2;
                String s2 = str2 +""+ str1;
                return s1.compareTo(s2);
            }
        });

        for(int k:list){
            s += k;
        }
        return s;
    }
}
/*
class Solution503 {
    public static String PrintMinNumber(int [] numbers) {
        int n;
        String s="";
        ArrayList<Integer> list= new ArrayList<Integer>();
        n=numbers.length;
        for(int i=0;i<n;i++){
            list.add(numbers[i]);

        }
        Collections.sort(list, new Comparator<Integer>(){

            public int compare(Integer str1,Integer str2){
                String s1=str1+""+str2;
                String s2=str2+""+str1;
                return s1.compareTo(s2);
            }
        });

        for(int j:list){
            s+=j;
        }
        return s;

    }
}*/
