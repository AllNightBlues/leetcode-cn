/**
 * @(#) LeetCode_322.java 1.0 2022-11-22
 * Copyright (c) 2022, AllNightBlues. ALL right reserved.
 * AllNightBlues PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com;

import java.util.Arrays;

/**
 * @ClassName LeetCode_322
 * @description:
 * @AUTHOR AllNightBlues
 * @Date 2022/11/22 20:25
 * @Version 1.0
 **/
public class LeetCode_322 {

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int impossible = amount + 1;
        int[][] dp = new int[n + 1][impossible];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = impossible;
            }
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            int m = coins[i - 1];
            for (int j = 0; j <= amount; j++) {
                for (int k = 0; k * m <= j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - k * m] + k);
                }
            }
        }
        return dp[n][amount] == impossible ? -1 : dp[n][amount];
    }


    public int coinChange1(int[] coins, int amount) {
        int impossible = amount + 1;
        int[] dp = new int[impossible];
        Arrays.fill(dp, impossible);
        dp[0] = 0;
        int n = coins.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[i]) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == impossible ? -1 : dp[amount];
    }


}
