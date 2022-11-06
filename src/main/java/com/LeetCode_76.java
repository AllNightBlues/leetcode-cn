/**
 * @(#) LeetCode_76.java 1.0 2022-11-06
 * Copyright (c) 2022, AllNightBlues. ALL right reserved.
 * AllNightBlues PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com;

/**
 * @ClassName LeetCode_76
 * @description:
 * @AUTHOR AllNightBlues
 * @Date 2022/11/06 16:16
 * @Version 1.0
 **/
public class LeetCode_76 {

    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }
        int[] tChars = new int[128];
        for (int i = 0; i < t.length(); i++) {
            tChars[t.charAt(i)]++;
        }
        int left = 0, right = 0;
        int size = Integer.MAX_VALUE, count = t.length();
        int start = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (tChars[c] > 0) {
                count--;
            }
            tChars[c]--;
            if (count == 0) {
                while (left < right && tChars[s.charAt(left)] < 0) {
                    tChars[s.charAt(left)]++;
                    left++;
                }
                if (right - left + 1 < size) {
                    size = right - left + 1;
                    start = left;
                }
                tChars[s.charAt(left)]++;
                left++;
                count++;
            }
            right++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }
}
