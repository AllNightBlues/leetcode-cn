/**
 * @(#) LeetCode_199.java 1.0 2022-10-23
 * Copyright (c) 2022, AllNightBlues. ALL right reserved.
 * AllNightBlues PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LeetCode_199
 * @description:
 * @AUTHOR AllNightBlues
 * @Date 2022/10/23 16:52
 * @Version 1.0
 **/
public class LeetCode_199 {

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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightView(root, result, 0);
        return result;
    }

    private void rightView(TreeNode root, List<Integer> result, int depth) {
        if (root == null) {
            return;
        }
        if (depth == result.size()) {
            result.add(root.val);
        }
        rightView(root.right, result, depth + 1);
        rightView(root.left, result, depth + 1);
    }
}
