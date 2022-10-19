/**
 * @(#) LeetCode_84.java 1.0 2022-10-19
 * Copyright (c) 2022, AllNightBlues. ALL right reserved.
 * AllNightBlues PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @ClassName LeetCode_84
 * @description:
 * @AUTHOR AllNightBlues
 * @Date 2022/10/19 23:38
 * @Version 1.0
 **/
public class LeetCode_84 {

    public int largestRectangleArea(int[] hs) {
        int n = hs.length;
        int[] l = new int[n], r = new int[n];
        Arrays.fill(l, -1); Arrays.fill(r, n);
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!d.isEmpty() && hs[d.peekLast()] > hs[i]) r[d.pollLast()] = i;
            d.addLast(i);
        }
        d.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!d.isEmpty() && hs[d.peekLast()] > hs[i]) l[d.pollLast()] = i;
            d.addLast(i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int t = hs[i], a = l[i], b = r[i];
            ans = Math.max(ans, (b - a - 1) * t);
        }
        return ans;
    }
}
