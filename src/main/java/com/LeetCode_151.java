/**
 * @(#) LeetCode_151.java 1.0 2022-11-04
 * Copyright (c) 2022, AllNightBlues. ALL right reserved.
 * AllNightBlues PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName LeetCode_151
 * @description:
 * @AUTHOR AllNightBlues
 * @Date 2022/11/04 13:28
 * @Version 1.0
 **/
public class LeetCode_151 {

    public String reverseWords(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }

        Deque<String> d = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();

        while (left <= right) {
            char c = s.charAt(left);
            if ((word.length() != 0) && (c == ' ')) {
                d.offerFirst(word.toString());
                word.setLength(0);
            } else if (c != ' ') {
                word.append(c);
            }
            left++;
        }
        d.offerFirst(word.toString());

        return String.join(" ", d);
    }

    public String reverseWords1(String s) {
        char[] charArray = s.toCharArray();
        int left = 0;
        int right = charArray.length - 1;
        StringBuilder sb = new StringBuilder();

        while(charArray[left] == ' ') left++;
        while(charArray[right] == ' ') right--;

        while(left <= right) {
            int index = right;
            while(index >= left && charArray[index] != ' ') {
                index--;
            }
            for (int i = index + 1; i <= right; i++) {
                sb.append(charArray[i]);
            }
            if (index > left) {
                sb.append(' ');
            }
            while (index >= left && charArray[index] == ' ') {
                index--;
            }
            right = index;
        }
        return sb.toString();
    }
}
