package com.leetcode.algorithm;

/**
 * Created by xiye on 9/11/16.
 */
public class ReverseString {

    public String reverseString(String s) {
        if(s==null||s.length()<=1)return s;
        int len = s.length();
        int j = len -1 ;
        StringBuilder sb = new StringBuilder();
        while(j>=0){
            sb.append(s.charAt(j));
            j--;
        }
        return sb.toString();
    }
    //Use a StringBuilder or char array instead of String, because String is immutable
}
