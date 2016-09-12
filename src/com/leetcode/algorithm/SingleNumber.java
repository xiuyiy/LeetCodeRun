package com.leetcode.algorithm;

import java.util.Arrays;

/**
 * Created by xiye on 9/11/16.
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        if(len==1)return nums[0];
        else if(len>=3){
            //case 1: first element
            if(nums[0]!=nums[1])return nums[0];
                //case 2: last element
            else if(nums[len-1]!=nums[len-2])return nums[len-1];
        }
        //case 3: in between
        for(int i=1; i<len-1; i++){
            if(nums[i-1]!=nums[i]&&nums[i]!=nums[i+1])return nums[i];
        }
        //didn't find any
        return -1;
    }
    //The "hard" part of this question is to separate the cases
}
