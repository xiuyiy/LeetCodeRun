package com.leetcode.algorithm;

/**
 * Created by xiye on 9/4/16.
 */
public class RegularExpressionMatching {

    public static boolean isMatch(String s, String p) {
        //pretty interesting question, but hard

        if(s == null || p == null)return false;
        boolean[][] state = new boolean[s.length()+1][p.length()+1];
        state[0][0] = true;

        //initialize state[0][j]
        for (int j = 1 ; j < state[0].length; j++) {
            if (p.charAt(j-1) == '*') {
                if (state[0][j-1] || state[0][j-2]) {
                    state[0][j] = true;
                }
            }
        }

        for (int i = 1; i < state.length; i++) {
            for (int j = 1; j < state[0].length; j++) {
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.') {
                    state[i][j] = state[i-1][j-1];
                }
                if (p.charAt(j-1) == '*') {
                    if (s.charAt(i-1) != p.charAt(j-2) && p.charAt(j-2) != '.') {
                        state[i][j] = state[i][j-2];
                    }else{
                        state[i][j] = state[i-1][j] || state[i][j-1] || state[i][j-2];
                    }
                }
            }
        }
        return state[s.length()][p.length()];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("a","b"));
    }
}
