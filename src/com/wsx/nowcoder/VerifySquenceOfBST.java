package com.wsx.nowcoder;

public class VerifySquenceOfBST {
    public static void main(String[] args) {
        int a[] = {4,8,6,12,16,14,10};
        Solution809 solution809 = new Solution809();
        final boolean b = solution809.VerifySquenceOfBST(a);
        System.out.println(b);
    }
}
class Solution809 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0){
            return false;
        }
        if(sequence.length == 1){
            return true;
        }
        return BSTTF(sequence,0,sequence.length-1);
    }
    private boolean BSTTF(int []a,int star,int root){
        if(star > root){
            return true;
        }
        int i = root;
        while(i > star && a[i-1]>a[root]){
            i--;
        }
        //i索引到左子树和右子树的分界处
        for(int j=star;j<i-1;j++){
            if(root<a[j]){
                return false;
            }
        }
        return BSTTF(a,star,i-1)&&BSTTF(a,i,root-1);
    }
}