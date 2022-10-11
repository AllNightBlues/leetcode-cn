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

}
