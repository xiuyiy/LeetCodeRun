package com.leetcode.algorithm;

import java.util.*;

/**
 * Created by xiye on 9/5/16.
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> setResult = new HashSet<>();
        //we need to sort the array first
        Arrays.sort(nums);
        int target = 0;
        int i = 0, j = 1, k = nums.length - 1;
        while(i<j&&j<k){
            int subSum = nums[i]+nums[j]+nums[k];
            if(subSum==target){
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                temp.add(nums[j]);
                temp.add(nums[k]);
                setResult.add(temp);
                j++;
            }else if(subSum<target){
                if(i+1<j){
                    i++;
                }else{

                    j++;
                }
            }else{
                k--;
            }
        }

        for(List<Integer> li : setResult){
            result.add(li);
        }
        return result;
    }//stupid solution

    public static void main(String[] args) {
        int[] input = {-1,0,1,2,-1,-4};
        System.out.println(threeSumBetter(input));
    }


    public static List<List<Integer>> threeSumBetter(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 3) return result;
        Arrays.sort(nums);
        int i = 0;
        while(i < nums.length - 2) {
            if(nums[i] > 0) break;
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                if(sum <= 0) while(nums[j] == nums[++j] && j < k);
                if(sum >= 0) while(nums[k--] == nums[k] && j < k);
            }
            while(nums[i] == nums[++i] && i < nums.length - 2);
        }

        return result;
    }
}
