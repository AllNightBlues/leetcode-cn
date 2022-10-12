/**
 * @(#) LeetCode_48.java 1.0 2022-10-09
 * Copyright (c) 2022, AllNightBlues. ALL right reserved.
 * AllNightBlues PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com;

/**
 * @ClassName LeetCode_48
 * @description: leetcode-cn-48 
 * @AUTHOR AllNightBlues
 * @Date 2022/10/09 21:01
 * @Version 1.0
 **/
public class LeetCode_48 {
    public void rotate(int[][] matrix) {
        int maxIndex = matrix.length - 1;
        for (int i = 0; i <= maxIndex; i++) {
            for (int j = 0; j <= maxIndex - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[maxIndex - j][maxIndex - i];
                matrix[maxIndex - j][maxIndex - i] = temp;
            }
        }

        for (int i = 0; i <= (maxIndex >> 1); i++) {
            for (int j = 0; j <= maxIndex; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[maxIndex - i][j];
                matrix[maxIndex - i][j] = temp;
            }
        }
    }
}
