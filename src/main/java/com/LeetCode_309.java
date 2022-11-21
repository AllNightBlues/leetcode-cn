/**
 * @(#) LeetCode_309.java 1.0 2022-11-21
 * Copyright (c) 2022, AllNightBlues. ALL right reserved.
 * AllNightBlues PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com;

/**
 * @ClassName LeetCode_309
 * @description:
 * @AUTHOR AllNightBlues
 * @Date 2022/11/21 11:16
 * @Version 1.0
 **/
public class LeetCode_309 {

    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[][] dp = new int[length][4];
        dp[0][2] = -prices[0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = prices[i] + dp[i - 1][2];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            dp[i][2] = Math.max(dp[i - 1][1] - prices[i], Math.max(dp[i - 1][2], dp[i - 1][3] - prices[i]));
            dp[i][3] = dp[i - 1][0];
        }
        return Math.max(dp[length - 1][0], Math.max(dp[length - 1][1], dp[length - 1][3]));
    }
}
