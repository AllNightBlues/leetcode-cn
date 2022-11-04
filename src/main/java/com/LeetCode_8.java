/**
 * @(#) LeetCode_8.java 1.0 2022-11-04
 * Copyright (c) 2022, AllNightBlues. ALL right reserved.
 * AllNightBlues PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com;

/**
 * @ClassName LeetCode_8
 * @description:
 * @AUTHOR AllNightBlues
 * @Date 2022/11/04 11:22
 * @Version 1.0
 **/
public class LeetCode_8 {

    public int myAtoi(String s) {
        int len = s.length();
        char[] charArray = s.toCharArray();
        int idx = 0;

        while (idx < len && charArray[idx] == ' ') {
            idx++;
        }

        if (idx == len) {
            return 0;
        }

        int sign = 1;
        char firstChar = charArray[idx];
        if (firstChar == '+') {
            idx++;
        } else if (firstChar == '-') {
            idx++;
            sign = -1;
        }

        int result = 0;
        while (idx < len) {
            char currentChar = charArray[idx];
            if (currentChar > '9' || currentChar < '0') {
                break;
            }
            if (result > Integer.MAX_VALUE / 10
                    || (result == Integer.MAX_VALUE / 10 && (currentChar - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }

            if (result < Integer.MIN_VALUE / 10
                    || (result == Integer.MIN_VALUE / 10 && (currentChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            result = result * 10 + sign * (currentChar - '0');
            idx++;
        }
        return result;
    }
}
