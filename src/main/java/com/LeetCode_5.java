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

    /**
     * DP solution
     *
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        int len = s.length();
        if (len == 1) {
            return s;
        }
        char[] charArray = s.toCharArray();
        if (len == 2) {
            if (charArray[1] == charArray[0]) {
                return s;
            } else {
                return s.substring(0, 1);
            }
        }
        int maxLen = 1;
        int begin = 0;

        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int j = 0; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
