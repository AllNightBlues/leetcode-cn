/**
 * @(#) LeetCode_102.java 1.0 2022-10-21
 * Copyright (c) 2022, AllNightBlues. ALL right reserved.
 * AllNightBlues PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName LeetCode_102
 * @description:
 * @AUTHOR AllNightBlues
 * @Date 2022/10/21 11:38
 * @Version 1.0
 **/
public class LeetCode_102 {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        levelPreVisit(result, root, 0);
        return result;
    }

    private void levelPreVisit(List<List<Integer>> result, TreeNode root, int height) {
        if (root == null) return;
        if (height >= result.size()) {
            result.add(new LinkedList<Integer>());
        }
        result.get(height).add(root.val);
        levelPreVisit(result, root.left, height + 1);
        levelPreVisit(result, root.right, height + 1);
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNodeNum = queue.size();
            LinkedList<Integer> subList = new LinkedList<>();
            for (int i = 0; i < levelNodeNum; i++) {
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            result.add(subList);
        }
        return result;
    }
}
