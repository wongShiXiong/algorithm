package com.wsx.nowcoder;

import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;

public class ReverseSentence {
    public static void main(String[] args) {
        String str = "student. a am I";
        final Solution222 solution222 = new Solution222();
        final String s = solution222.ReverseSentence(str);
        System.out.println(s);
    }

}
class Solution222 {
    public String ReverseSentence(String str) {
        if(str.trim().equals("")){
            return str;
        }
        StringBuffer sb = new StringBuffer();
        String[] s = str.split(" ");
        for (int i = s.length; i > 0; i--){
            sb.append(s[i-1]);
            if(i > 1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
