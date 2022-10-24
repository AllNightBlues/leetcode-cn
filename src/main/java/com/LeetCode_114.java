/**
 * @(#) LeetCode_114.java 1.0 2022-10-22
 * Copyright (c) 2022, AllNightBlues. ALL right reserved.
 * AllNightBlues PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com;

/**
 * @ClassName LeetCode_114
 * @description:
 * @AUTHOR AllNightBlues
 * @Date 2022/10/22 15:55
 * @Version 1.0
 **/
public class LeetCode_114 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                TreeNode rightmost = root.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }
                rightmost.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }
}
