package com.wsx.nowcoder;

public class GetNumberOfK {
    public static void main(String[] args) {
        int a[] = {1,3,4,6,6,6,6,7};
        final int i = Solution806.GetNumberOfK(a, 6);
        System.out.println(i);
    }

}
class Solution806 {
    public static int GetNumberOfK(int [] array , int k) {
        if(array.length == 0){
            return 0;
        }
        int FirstKey = getFirstKey(array,0,array.length -1,k);
        int LastKey = getLastKey(array,0,array.length -1,k);
        if(FirstKey != -1&&LastKey != -1){
            return LastKey - FirstKey + 1;
        }else{
            return 0;
        }
    }
    //递归二分查找
    private static int getFirstKey(int [] array,int start,int end,int k){
        if(start > end){
            return -1;
        }
        int mid = (start+end) >> 1;
        if(array[mid] > k){
            //左递归
            return getFirstKey(array,start,mid - 1,k);
        }else if(array[mid] < k){
            return getFirstKey(array,mid + 1,end,k);
        }else if(mid-1 >= 0 && array[mid - 1] == k){
            return getFirstKey(array,start,mid - 1,k);
        }else{
            return mid;
        }
    }
    //非递归二分查找
    private static int getLastKey(int [] array,int start,int end,int k){
        if(start>end){
            return -1;
        }
        int mid = (start + end) >> 1;
        while(start <= end){
            if(array[mid] > k){
                end = mid - 1;
            }else if(array[mid]<k){
                start = mid + 1;
            }else if(mid+1<array.length && array[mid+1] == k ){
                start = mid + 1;
            }else{
                return mid;
            }
            mid = (start + end) >> 1;
        }
        return -1;
    }
}