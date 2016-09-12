package com.leetcode.algorithm;

/**
 * Created by xiye on 9/11/16.
 */
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        if(nums.length<=1)return;
        int i = 0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=0){
                nums[i++]=nums[j];
            }
        }
        for(;i<nums.length;i++){
            nums[i]=0;
        }

    }
}
