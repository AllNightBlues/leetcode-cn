/**
 * @(#) LeetCode_103.java 1.0 2022-10-21
 * Copyright (c) 2022, AllNightBlues. ALL right reserved.
 * AllNightBlues PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName LeetCode_103
 * @description:
 * @AUTHOR AllNightBlues
 * @Date 2022/10/21 14:09
 * @Version 1.0
 **/
public class LeetCode_103 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        zigzagLevelOrder(result, root, 0);
        return result;
    }

    private void zigzagLevelOrder(List<List<Integer>> result, TreeNode root, int height) {
        if (root == null) return;
        if (height >= result.size()) {
            result.add(new LinkedList<Integer>());
        }
        if (height % 2 == 0) {
            result.get(height).add(root.val);
        } else {
            result.get(height).add(0, root.val);
        }
        zigzagLevelOrder(result, root.left, height + 1);
        zigzagLevelOrder(result, root.right, height + 1);
    }

    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        queue.offer(root);
        boolean isOrderLeft = true;
        while (!queue.isEmpty()) {
            int levelNodeNum = queue.size();
            LinkedList<Integer> subList = new LinkedList<>();
            for (int i = 0; i < levelNodeNum; i++) {
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                if (isOrderLeft) {
                    subList.add(queue.poll().val);
                } else {
                    subList.add(0, queue.poll().val);
                }
            }
            isOrderLeft = !isOrderLeft;
            result.add(subList);
        }
        return result;
    }
}
