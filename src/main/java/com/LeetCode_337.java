/**
 * @(#) LeetCode_337.java 1.0 2022-11-23
 * Copyright (c) 2022, AllNightBlues. ALL right reserved.
 * AllNightBlues PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com;

/**
 * @ClassName LeetCode_337
 * @description:
 * @AUTHOR AllNightBlues
 * @Date 2022/11/23 10:44
 * @Version 1.0
 **/
public class LeetCode_337 {

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

    public int rob(TreeNode root) {
        int[] result = robNode(root);
        return Math.max(result[0], result[1]);
    }

    private int[] robNode(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] left = robNode(root.left);
        int[] right = robNode(root.right);
        int stealCurr = root.val + left[1] + right[1];
        int noStealCurr = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{stealCurr, noStealCurr};
    }
}
