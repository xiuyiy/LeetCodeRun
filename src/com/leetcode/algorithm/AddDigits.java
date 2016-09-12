package com.leetcode.algorithm;

/**
 * Created by xiye on 9/11/16.
 */
public class AddDigits {
    //This method uses loop
    public int addDigits(int num) {
        if(num<10)return num;

        int newNum = 0;
        while(num!=0){
            newNum += num%10;
            num/=10;
        }
        return addDigits(newNum);
    }

    //This method does not use loop, but it is really hard to think of
    //This is magic
    public int addDigitsNoLoop(int n){
        if(n<10)return n;
        else if(n%9==0)return 9;
        else return n%9;
    }
}
