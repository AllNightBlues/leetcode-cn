/**
 * @(#) LeetCode_42.java 1.0 2022-11-26
 * Copyright (c) 2022, AllNightBlues. ALL right reserved.
 * AllNightBlues PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com;

/**
 * @ClassName LeetCode_42
 * @description:
 * @AUTHOR AllNightBlues
 * @Date 2022/11/26 16:14
 * @Version 1.0
 **/
public class LeetCode_42 {

    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }
        int[] leftDp = new int[n];
        leftDp[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftDp[i] = Math.max(leftDp[i - 1], height[i]);
        }
        int[] rightDp = new int[n];
        rightDp[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightDp[i] = Math.max(rightDp[i + 1], height[i]);
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += Math.min(leftDp[i], rightDp[i]) - height[i];
        }
        return result;
    }
}
