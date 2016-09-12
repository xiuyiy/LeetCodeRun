package com.leetcode.algorithm;

/**
 * Created by xiye on 9/11/16.
 */
public class InvertBinaryTree {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    public TreeNode invertTree(TreeNode root) {
        if(root==null||root.left==null&&root.right==null)return root;
        invertTreeHelper(root);
        return root;

    }

    public void invertTreeHelper(TreeNode root){
        if(root==null||(root.left==null&&root.right==null))return;
        else if(root.left==null){
            root.left = root.right;
            root.right = null;
            invertTreeHelper(root.left);
        }else if(root.right==null){
            root.right = root.left;
            root.left = null;
            invertTreeHelper(root.right);
        }else{
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = temp;
            invertTreeHelper(root.right);
            invertTreeHelper(root.left);
        }
    }
}
