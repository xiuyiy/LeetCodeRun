package com.leetcode.algorithm;

/**
 * Created by xiye on 9/11/16.
 */
public class SumOfTwoIntegers {
    public int getSum(int a, int b) {

        if (b==0) return a; //Why b==0 return a instead of a==0 return b??
        int sum, carry;
        sum = a^b; // Bitwise XOR
        carry = (a&b)<<1;
        return getSum(sum, carry);
    }

    //This is magic
}
