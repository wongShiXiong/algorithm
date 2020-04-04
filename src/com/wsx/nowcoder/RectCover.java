package com.wsx.nowcoder;

public class RectCover {
    public class Solution {
        public int RectCover(int target) {
            if(target < 1){
                return -1;
            }else if(target == 1 || target == 2 ){
                return target;
            }else{
                return RectCover(target - 1) + RectCover(target - 2);
            }
        }
    }
}
