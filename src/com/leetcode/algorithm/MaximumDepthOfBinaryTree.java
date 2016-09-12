package com.leetcode.algorithm;

import javax.swing.tree.TreeNode;

/**
 * Created by xiye on 9/11/16.
 */
public class MaximumDepthOfBinaryTree {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }
    public int maxDepth(TreeNode root) {
       if(root==null)return 0;
        else return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
}
