/**
 * @(#) LeetCode_34.java 1.0 2022-10-30
 * Copyright (c) 2022, AllNightBlues. ALL right reserved.
 * AllNightBlues PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com;

/**
 * @ClassName LeetCode_34
 * @description:
 * @AUTHOR AllNightBlues
 * @Date 2022/10/30 17:37
 * @Version 1.0
 **/
public class LeetCode_34 {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        if (result[0] == -1) return new int[]{-1, -1};
        result[1] = findLast(result[0], nums, target);
        return result;
    }

    private int findLast(int first, int[] nums, int target) {
        int idx = -1;
        int start = first;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            if (nums[mid] == target) idx = mid;
        }
        return idx;
    }

    private int findFirst(int[] nums, int target) {
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            if (nums[mid] == target) idx = mid;
        }
        return idx;
    }
}
