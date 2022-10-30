/**
 * @(#) LeetCode_33.java 1.0 2022-10-30
 * Copyright (c) 2022, AllNightBlues. ALL right reserved.
 * AllNightBlues PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com;

/**
 * @ClassName LeetCode_33
 * @description:
 * @AUTHOR AllNightBlues
 * @Date 2022/10/30 10:48
 * @Version 1.0
 **/
public class LeetCode_33 {

    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int numMid = nums[mid];
            if (numMid == target) return mid;
            if (!((numMid < nums[0]) == (target < nums[0]))) {
                numMid = target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            if (numMid < target) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }
}
