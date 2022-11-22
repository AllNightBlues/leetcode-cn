/**
 * @(#) LeetCode_152.java 1.0 2022-11-19
 * Copyright (c) 2022, AllNightBlues. ALL right reserved.
 * AllNightBlues PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com;

/**
 * @ClassName LeetCode_152
 * @description:
 * @AUTHOR AllNightBlues
 * @Date 2022/11/19 20:21
 * @Version 1.0
 **/
public class LeetCode_152 {

    public int maxProduct(int[] nums) {
        int length = nums.length;
        int[] maxF = new int[length];
        int[] minF = new int[length];
        System.arraycopy(nums, 0, maxF, 0, length);
        System.arraycopy(nums, 0, minF, 0, length);
        for (int i = 1; i < length; ++i) {
            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
            minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
        }
        int ans = maxF[0];
        for (int i = 1; i < length; ++i) {
            ans = Math.max(ans, maxF[i]);
        }
        return ans;
    }

    public int maxProduct1(int[] nums) {
        if (nums.length == 1) return nums[0];
        int answer = nums[0];
        int[] maxDP = new int[nums.length];
        int[] minDP = new int[nums.length];
        maxDP[0] = nums[0]; minDP[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxDP[i] = Math.max(maxDP[i - 1] * nums[i], Math.max(nums[i], maxDP[i - 1] * nums[i]));
            minDP[i] = Math.min(minDP[i - 1] * nums[i], Math.min(nums[i], minDP[i - 1] * nums[i]));
            answer = Math.max(answer, maxDP[i]);
        }
        return answer;
    }

    public int maxProduct2(int[] nums) {
        if (nums.length == 1) return nums[0];
        int answer = nums[0], max = nums[0], min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int currMax = max * nums[i], currMin = min * nums[i];
            max = Math.max(nums[i], Math.max(currMax, currMin));
            min = Math.min(nums[i], Math.min(currMax, currMin));
            answer = Math.max(answer, max);
        }
        return answer;
    }

}
