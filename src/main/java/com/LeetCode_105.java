/**
 * @(#) LeetCode_105.java 1.0 2022-10-22
 * Copyright (c) 2022, AllNightBlues. ALL right reserved.
 * AllNightBlues PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com;

import java.util.HashMap;

/**
 * @ClassName LeetCode_105
 * @description:
 * @AUTHOR AllNightBlues
 * @Date 2022/10/22 14:54
 * @Version 1.0
 **/
public class LeetCode_105 {

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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(0, 0, inorder.length - 1, preorder, inorder);
    }

    private TreeNode buildTree(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        root.left = buildTree(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = buildTree(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }

    public TreeNode buildTree1(int[] preorder, int[] inorder) {

        HashMap<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildTreeWithMap(0, 0, inorder.length - 1, preorder, inorder, inMap);
    }

    private TreeNode buildTreeWithMap(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder, HashMap<Integer, Integer> inMap) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = inMap.get(root.val);
        root.left = buildTreeWithMap(preStart + 1, inStart, inIndex - 1, preorder, inorder, inMap);
        root.right = buildTreeWithMap(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder, inMap);
        return root;
    }

    int p = 0;
    int i = 0;
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        return solute((long) Integer.MAX_VALUE+1,preorder,inorder);
    }

    public TreeNode solute(long stop,int[] pre,int[] in){
        if(i<in.length&&in[i] != stop){
            TreeNode root = new TreeNode(pre[p++]);
            root.left = solute(root.val,pre,in);
            i++;
            root.right = solute(stop,pre,in);
            return root;
        }
        return null;
    }
}
