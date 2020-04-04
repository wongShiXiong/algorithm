package com.wsx.nowcoder;

public class Power {
}
class Solution602 {

    public double Power(double base, int exponent) {
        double res = 1,curr = base;
        int n;
        if(exponent > 0){
            n = exponent;
        }else if(exponent < 0 ){
            if(base==0){
                throw new RuntimeException("不能负数？");
            }
            n = -exponent ;
        }else{
            return 1;
        }

        while(n!= 0){
            if((n&1) == 1){ //2的5次方，0101 0001    0010  0001     0001  0001
                res *= curr; //res = 2;   res =2    res= 32
            }
            curr *= curr; //curr = 4;curr = 16  ; curr = 16平方
            n>>=1;
        }
        return exponent >0 ?res:1/res;
    }
}



    /**
     * 1.全面考察指数的正负、底数是否为零等情况。
     * 2.写出指数的二进制表达，例如13表达为二进制1101。
     * 3.举例:10^1101 = 10^0001*10^0100*10^1000。
     * 4.通过&1和>>1来逐位读取1101，为1时将该位代表的乘数累乘到最终结果。
     */
/*    public double Power(double base, int n) {
        double res = 1,curr = base;
        int exponent;  //0110
        if(n>0){
            exponent = n;
        }else if(n<0){
            if(base==0)
                throw new RuntimeException("分母不能为0");
            exponent = -n;
        }else{// n==0
            return 1;// 0的0次方     2   010       3   011
        }
        while(exponent!=0){
            if((exponent&1)==1)
                res*=curr; //1*2    2*4
            curr*=curr;// 翻倍  2*2  16
            exponent>>=1;// 右移一位      n右移一位再付给他自己   011->001->000
        }
        return n>=0?res:(1/res);
    }*/