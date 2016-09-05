package com.leetcode.algorithm;

/**
 * Created by xiye on 9/4/16.
 */
public class StringtoIntegerATOI {

    public static int myAtoi(String str) {
        //It asks to covert an integet in a String type to an actual integer
        //all the invalide input needs to return 0
        //invalid examples: +-2
        if(str == null || str.length() == 0 ) return 0;
        int sign = 1, len = str.length(), i = len - 1;
        double result = 0, base  = 1;
        boolean signed = false, spaced = false; //spaced == true meaning

        for(;i>=0;i--) {
            char curr = str.charAt(i);


            if(curr == ' ') spaced = true ;
            else if(curr == '+') {
                if(signed) return 0;
                else {
                    signed = true;
                    if(spaced) {
                        result = 0;
                        base = 1;
                        sign = 1;
                    }
                }
            }
            else if(curr == '-') {
                if(signed) return 0;
                else {
                    signed = true;
                    sign = -1;
                    if(spaced) {
                        result = 0;
                        base = 1;
                        sign = 1;
                    }
                }
            }
            // make sure this is done after checking the white spaces, +/- signs, otherwise, it would be a problem
            // because ' ', '+', '-' are also without the range of ['0', '9']
            else if(curr < '0' || curr > '9' || curr == ' ') {
                result = 0;
                //make sure to reset the base and sign too
                base = 1;
                sign = 1;
            }
            else {
                if(spaced) {
                    result = 0;
                    base = 1;
                    sign = 1;
                }
                result += base * (curr - '0');
                base*=10;
                spaced = false;
            }

        }

        result *= sign;
        if(result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        else if(result < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return (int)result;

    }

    public static void main(String[] args) {

        System.out.println(myAtoi("    10522545459"));
    }

    //This solution is ugly as hell

    //Here is a better solution
    public int myAtoiGood(String str) {
        if (str.isEmpty()) {
            return 0;
        }

        int sign = 1, base = 0, i = 0;
        while (str.charAt(i) == ' ') i++;

        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            sign = str.charAt(i++) == '-' ? -1 : 1;
        }
        while (i < str.length() && str.charAt(i) <= '9' && str.charAt(i) >= '0') {
            if (base > Integer.MAX_VALUE/10 || base == Integer.MAX_VALUE/10 && str.charAt(i) - '0' > 7 ) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            base = 10 * base + (str.charAt(i++) - '0');
        }
        return base*sign;
    }
}
