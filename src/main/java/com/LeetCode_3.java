/**
 * @(#) LeetCode_3.java 1.0 2022-11-02
 * Copyright (c) 2022, AllNightBlues. ALL right reserved.
 * AllNightBlues PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName LeetCode_3
 * @description:
 * @AUTHOR AllNightBlues
 * @Date 2022/11/02 14:45
 * @Version 1.0
 **/
public class LeetCode_3 {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        int rk = -1, ans = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}
