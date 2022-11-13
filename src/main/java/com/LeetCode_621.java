/**
 * @(#) LeetCode_621.java 1.0 2022-11-12
 * Copyright (c) 2022, AllNightBlues. ALL right reserved.
 * AllNightBlues PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com;

/**
 * @ClassName LeetCode_621
 * @description:
 * @AUTHOR AllNightBlues
 * @Date 2022/11/12 17:19
 * @Version 1.0
 **/
public class LeetCode_621 {
    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        for (char c : tasks) {
            arr[c - 'A']++;
        }
        int max = 0;
        for (int i = 0; i < 26; i++) {
            max = Math.max(max, arr[i]);
        }
        int ret = (max - 1) * (n + 1);
        for (int i = 0; i < 26; i++) {
            if (arr[i] == max) {
                ret++;
            }
        }
        return Math.max(ret, tasks.length);
    }
}
