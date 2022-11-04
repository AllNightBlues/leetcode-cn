/**
 * @(#) LeetCode_5.java 1.0 2022-11-04
 * Copyright (c) 2022, AllNightBlues. ALL right reserved.
 * AllNightBlues PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com;

/**
 * @ClassName LeetCode_5
 * @description:
 * @AUTHOR AllNightBlues
 * @Date 2022/11/04 10:48
 * @Version 1.0
 **/
public class LeetCode_5 {

    public String longestPalindrome(String s) {
        int maxStart = 0, maxEnd = 0;
        for (int i = 0; i < s.length(); i++) {
            int charCenterLen = expandAroundCenter(s, i, i);
            int blankCenterLen = expandAroundCenter(s, i, i + 1);
            int len = Math.max(charCenterLen, blankCenterLen);
            if (len > maxEnd - maxStart) {
                maxStart = i - (len - 1) / 2;
                maxEnd = i + len / 2;
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
