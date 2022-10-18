/**
 * @(#) LeetCode_739.java 1.0 2022-10-17
 * Copyright (c) 2022, AllNightBlues. ALL right reserved.
 * AllNightBlues PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com;

import java.util.LinkedList;

/**
 * @ClassName LeetCode_739
 * @description:
 * @AUTHOR AllNightBlues
 * @Date 2022/10/17 23:29
 * @Version 1.0
 **/
public class LeetCode_739 {

    public int[] dailyTemperatures(int[] temperatures) {
        LinkedList<Integer> stack = new LinkedList<>();
        int[] ret = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                ret[idx] = i - idx;
            }
            stack.push(i);
        }
        return ret;
    }
}
