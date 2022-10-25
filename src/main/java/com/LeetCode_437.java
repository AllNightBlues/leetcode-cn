/**
 * @(#) LeetCode_437.java 1.0 2022-10-24
 * Copyright (c) 2022, AllNightBlues. ALL right reserved.
 * AllNightBlues PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com;

import java.util.HashMap;

/**
 * @ClassName LeetCode_437
 * @description:
 * @AUTHOR AllNightBlues
 * @Date 2022/10/24 22:11
 * @Version 1.0
 **/
public class LeetCode_437 {

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

    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0L, 1);
        return travelsal(root, 0L, targetSum, prefixSum);
    }

    private int travelsal(TreeNode root, long currSum, long target, HashMap<Long, Integer> prefixSum) {
        if (root == null) {
            return 0;
        }
        currSum += root.val;

        long result = prefixSum.getOrDefault(currSum - target, 0);
        prefixSum.put(currSum, prefixSum.getOrDefault(currSum, 0) + 1);

        result = result + travelsal(root.left, currSum, target, prefixSum)
                + travelsal(root.right, currSum, target, prefixSum);
        
        prefixSum.put(currSum, prefixSum.get(currSum) - 1);
        return (int) result;
    }


}
