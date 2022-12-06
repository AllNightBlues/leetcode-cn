/**
 * @(#) LeetCode_494.java 1.0 2022-11-24
 * Copyright (c) 2022, AllNightBlues. ALL right reserved.
 * AllNightBlues PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com;

/**
 * @ClassName LeetCode_494
 * @description:
 * @AUTHOR AllNightBlues
 * @Date 2022/11/24 13:52
 * @Version 1.0
 **/
public class LeetCode_494 {

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        if (n == 1) return nums[0] == target || nums[0] == -target ? 1 : 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int need = diff / 2;
        int[] dp = new int[need + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = need; j >= num; j--) {
                dp[j] = dp[j] + dp[j - num];
            }
        }
        return dp[need];
    }
}
