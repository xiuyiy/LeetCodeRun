package com.leetcode.algorithm;

/**
 * Created by xiye on 9/2/16.
 */
public class LongestSubstringWithoutRepeatingCharacters_3 {


    /*Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3.

Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

*/


    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();

        //Base case
        if (len == 0) return 0;
        else if (len == 1) return 1;

        int result = 0;
        int currMax = 0;
        boolean[] counter;
        int i, j;
        i = 0;
        j = 0;

        while (i < len) {
            j = i;
            //reset counter and currMax
            counter = new boolean[256];
            currMax = 0;
            while (j < len) {
                if (counter[j] == true || j == len) {
                    i++;
                    if (currMax != 0 && currMax > result) {
                        //update the new Max length
                        result = currMax;
                    }
                    break;
                } else {
                    currMax++;
                    //set the counter to true, so that we know this letter was visited
                    counter[j] = true;
                    //increment j to see if it can go further
                    j++;
                }
            }
        }
        return result;
    }

    //The time complexity of this algorithm is n^2

    public static void main(String[] args) {

        int max_length = LongestSubstringWithoutRepeatingCharacters_3.lengthOfLongestSubstring("ab");
        System.out.println(max_length);
    }

}
