package com.wsx.nowcoder;

public class TheFirstChar2 {
    public static void main(String[] args) {
        final Solution33 solution33 = new Solution33();
        solution33.Insert('g');
        solution33.Insert('o');
        solution33.Insert('o');
        solution33.Insert('g');
        solution33.Insert('l');
        solution33.Insert('e');
        final char c = solution33.FirstAppearingOnce();
        System.out.println(c);
    }
}
class Solution33 {
    private int allascii[] = new int[256];
    private int index = 0;
    //Insert one char from stringstream
    //构造函数初始化
    public Solution33(){
        for (int i = 0;  i < 256; i++){
            allascii[i] = -1;
        }
    }
    public void Insert(char ch)
    {
        if(allascii[ch] == -1){
            allascii[ch] = index;
        }else if(allascii[ch] >= 0){
            allascii[ch] = -2;
        }
        index++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char ch = '\0';
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < 256; i++){
            if(allascii[i] >= 0 && allascii[i] < minValue){
                ch = (char)i;
                minValue = allascii[i];
            }
        }
        if(ch == '\0'){
            return '#';
        }else {
            return ch;
        }
    }
}