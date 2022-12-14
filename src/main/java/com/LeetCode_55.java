/**
 * @(#) LeetCode_55.java 1.0 2022-10-11
 * Copyright (c) 2022, AllNightBlues. ALL right reserved.
 * AllNightBlues PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com;

/**
 * @ClassName LeetCode_55
 * @description:
 * @AUTHOR AllNightBlues
 * @Date 2022/10/11 21:43
 * @Version 1.0
 **/
public class LeetCode_55 {

    public boolean canJump(int[] nums) {
        if (nums.length < 2) return true;
        for (int curr = nums.length - 2; curr >= 0 ; curr--) {
            if (nums[curr] == 0) {
                int neededJumps = 1;
                while (neededJumps > nums[curr]) {
                    neededJumps++;
                    curr--;
                    if (curr < 0) return false;
                }
            }
        }
        return true;
    }

    public boolean canJump1(int[] nums) {
        int maxStep = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (maxStep == 0) return false;
            maxStep = Math.max(maxStep - 1, nums[i]);
        }
        return true;
    }

    public boolean canJump2(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; i++) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

}
