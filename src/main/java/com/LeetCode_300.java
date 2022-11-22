/**
 * @(#) LeetCode_300.java 1.0 2022-11-21
 * Copyright (c) 2022, AllNightBlues. ALL right reserved.
 * AllNightBlues PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com;

import java.util.Arrays;

/**
 * @ClassName LeetCode_300
 * @description:
 * @AUTHOR AllNightBlues
 * @Date 2022/11/21 10:13
 * @Version 1.0
 **/
public class LeetCode_300 {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int lengthOfLIS1(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        int result = 1;
        dp[0] = nums[0];
        for (int i = 1; i < length; i++) {
            if (nums[i] > dp[result - 1]) {
                dp[result] = nums[i];
                result++;
            } else {
                int start = 0, end = result;
                while (start < end) {
                    int m = (start + end) / 2;
                    if (dp[m] < nums[i]) {
                        start = m + 1;
                    } else {
                        end = m;
                    }
                }
                dp[start] = nums[i];
            }
        }
        return result;
    }


}
