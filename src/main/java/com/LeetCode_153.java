/**
 * @(#) LeetCode_153.java 1.0 2022-11-02
 * Copyright (c) 2022, AllNightBlues. ALL right reserved.
 * AllNightBlues PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com;

/**
 * @ClassName LeetCode_153
 * @description:
 * @AUTHOR AllNightBlues
 * @Date 2022/11/02 10:40
 * @Version 1.0
 **/
public class LeetCode_153 {

    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            if (start + 1 == end) {
                return Math.min(nums[start], nums[end]);
            }
            int mid = (start + end) / 2;
            if (nums[start] <= nums[mid] && nums[mid] <= nums[end]) {
                return nums[start];
            } else if (nums[start] >= nums[mid] && nums[mid] < nums[end]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return -1;
    }

    public int findMin1(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
