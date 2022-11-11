/**
 * @(#) LeetCode_53.java 1.0 2022-11-11
 * Copyright (c) 2022, AllNightBlues. ALL right reserved.
 * AllNightBlues PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com;

/**
 * @ClassName LeetCode_53
 * @description:
 * @AUTHOR AllNightBlues
 * @Date 2022/11/11 16:18
 * @Version 1.0
 **/
public class LeetCode_53 {

    public int maxSubArray(int[] nums) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (currSum > 0) {
                currSum = currSum + nums[i];
            } else {
                currSum = nums[i];
            }
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}
