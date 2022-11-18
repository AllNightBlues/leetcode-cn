/**
 * @(#) LeetCode_91.java 1.0 2022-11-17
 * Copyright (c) 2022, AllNightBlues. ALL right reserved.
 * AllNightBlues PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com;

/**
 * @ClassName LeetCode_91
 * @description:
 * @AUTHOR AllNightBlues
 * @Date 2022/11/17 16:22
 * @Version 1.0
 **/
public class LeetCode_91 {

    public int numDecodings(String s) {
        int n = s.length();
        int prePre = 0, pre = 1, curr = 0;
        for (int i = 1; i <= n; i++) {
            curr = 0;
            if (s.charAt(i - 1) != '0') curr += pre;
            if (i >= 2) {
                int num = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
                if (num >= 10 && num <= 26) curr += prePre;
            }
            prePre = pre;
            pre = curr;
        }
        return curr;
    }

}
