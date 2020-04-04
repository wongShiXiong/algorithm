package com.bear.sparsearray;

public class SparseArray {
    public static void main(String[] args) {
        //创建一个原始的二维数组
        int ChessArr1[][] = new int[11][11];
        //1表示黑子 2表示蓝子
        ChessArr1[1][2] = 1;
        ChessArr1[2][3] = 2;

        System.out.println("原始的二维数组");

        for(int row[]:ChessArr1){
            for (int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //计算数组中非0数

        int sum = 0;

        for (int i = 0; i < 11; i++){
            for (int j = 0; j < 11; j++){
                if (ChessArr1[i][j]!=0){
                    sum++;
                }
            }
        }

        //创建稀疏数组
        int SparseArr[][] = new int [sum+1][3];

        //给稀疏数组赋值
        SparseArr[0][0] = 11;
        SparseArr[0][1] = 11;

        SparseArr[0][2] = sum;

        int count = 0;
        for (int i = 0; i < 11; i++){
            for (int j = 0; j < 11; j++){
                if(ChessArr1[i][j]!=0){
                    count++;
                    SparseArr[count][0] = i;
                    SparseArr[count][1] = j;

                    SparseArr[count][2] = ChessArr1[i][j];

                }
            }
        }

        System.out.println();
        System.out.println("创建的稀疏数组");
//第一种遍历方法
/*        for (int [] row : SparseArr){
            for (int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }*/
//第二种遍历方法
        for (int i = 0; i < SparseArr.length;i++){
            System.out.printf("%d\t%d\t%d\t\n",SparseArr[i][0],SparseArr[i][1],SparseArr[i][2]);
        }

        //将稀疏数组转化为二维数组


        //根据稀疏数组的第一行创建二维数组
        int ChessArr2[][] = new int[SparseArr[0][0]][SparseArr[0][1]];

        //读取稀疏数组，并将稀疏少数族值放入二维数组中

        for (int i = 1 ; i < SparseArr.length; i++){
            ChessArr2[SparseArr[i][0]][SparseArr[i][1]] = SparseArr[i][2];
        }

        //输出二维数组
        System.out.println();
        System.out.println("复原后的二维数组");
        for(int row[]:ChessArr2){
            for (int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }













    }
}
