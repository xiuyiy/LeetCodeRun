package com.leetcode.algorithm;

import java.util.Arrays;

/**
 * Created by xiye on 9/11/16.
 */
public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        char[] ss = sortString(s);
        char[] tt = sortString(t);
        for(int i=0;i<ss.length;i++){
            if(ss[i]!=tt[i])return tt[i];
        }
        return tt[tt.length-1];

    }

    public char[] sortString(String str){
        char[] temp = str.toCharArray();
        Arrays.sort(temp);
        return temp;
    }
    //The trick is that you need to sort the array first
}
