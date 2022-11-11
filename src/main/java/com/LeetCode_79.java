/**
 * @(#) LeetCode_79.java 1.0 2022-11-11
 * Copyright (c) 2022, AllNightBlues. ALL right reserved.
 * AllNightBlues PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com;

/**
 * @ClassName LeetCode_79
 * @description:
 * @AUTHOR AllNightBlues
 * @Date 2022/11/11 15:28
 * @Version 1.0
 **/
public class LeetCode_79 {

    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (backTrack(board, x, y, w, 0)) return true;
            }
        }
        return false;
    }

    private boolean backTrack(char[][] board, int x, int y, char[] word, int currLength) {
        if (currLength == word.length) return true;
        if (x < 0 || y < 0 || x == board.length || y == board[x].length) return false;
        if (board[x][y] != word[currLength]) return false;
        board[x][y] ^= 256;
        boolean exist = backTrack(board, x, y + 1, word, currLength + 1)
                || backTrack(board, x - 1, y, word, currLength + 1)
                || backTrack(board, x + 1, y, word, currLength + 1)
                || backTrack(board, x, y - 1, word, currLength + 1);
        board[x][y] ^= 256;
        return exist;
    }

}
