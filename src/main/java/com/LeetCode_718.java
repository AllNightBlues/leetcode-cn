/**
 * @(#) LeetCode_718.java 1.0 2022-11-26
 * Copyright (c) 2022, AllNightBlues. ALL right reserved.
 * AllNightBlues PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com;

/**
 * @ClassName LeetCode_718
 * @description:
 * @AUTHOR AllNightBlues
 * @Date 2022/11/26 15:20
 * @Version 1.0
 **/
public class LeetCode_718 {

    public int findLength(int[] nums1, int[] nums2) {
        int n1Length = nums1.length;
        int n2Length = nums2.length;

        int[][] dp = new int[n1Length + 1][n2Length + 1];
        int result = 0;
        for (int i = 1; i <= n1Length; i++) {
            for (int j = 1; j <= n2Length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }

    public int findLength1(int[] nums1, int[] nums2) {
        int n1Length = nums1.length;
        int n2Length = nums2.length;

        int[] dp = new int[n2Length + 1];
        int result = 0;
        for (int i = 1; i <= n1Length; i++) {
            for (int j = n2Length; j > 0; j--) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[j] = dp[j - 1] + 1;
                } else {
                    dp[j] = 0;
                }
                result = Math.max(result, dp[j]);
            }
        }
        return result;
    }


}
