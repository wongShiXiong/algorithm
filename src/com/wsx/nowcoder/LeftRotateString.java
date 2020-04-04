package com.wsx.nowcoder;

public class LeftRotateString {
    public static void main(String[] args) {
        String s= "abcXYZdef";
        int n = 8;
        final String s1 = Solution703.LeftRotateString(s, n);
        System.out.println(s1);
    }


}
class Solution703 {
    public static String LeftRotateString(String str,int n) {
        int len = str.length();
        if(len==0||n<=0){
            return str;
        }
        n = n%len;
        len = len + n;
        String st = str + str;
        return st.substring(n,len);
    }
}