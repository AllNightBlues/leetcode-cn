/**
 * @(#) LeetCode_450.java 1.0 2022-10-25
 * Copyright (c) 2022, AllNightBlues. ALL right reserved.
 * AllNightBlues PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com;

/**
 * @ClassName LeetCode_450
 * @description:
 * @AUTHOR AllNightBlues
 * @Date 2022/10/25 21:13
 * @Version 1.0
 **/
public class LeetCode_450 {

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

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val){
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode rightMin = root.right;
                while (rightMin.left != null) {
                    rightMin = rightMin.left;
                }
                rightMin.left = root.left;
                root = root.right;
            }
        }
        return root;
    }
}
