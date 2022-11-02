/**
 * @(#) LeetCode_240.java 1.0 2022-11-02
 * Copyright (c) 2022, AllNightBlues. ALL right reserved.
 * AllNightBlues PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com;

/**
 * @ClassName LeetCode_240
 * @description:
 * @AUTHOR AllNightBlues
 * @Date 2022/11/02 11:41
 * @Version 1.0
 **/
public class LeetCode_240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }
        int cols = matrix[0].length - 1;
        int rows = matrix.length - 1;
        if (target > matrix[rows][cols]) return false;

        int currentCol = cols;
        int currentRow = 0;
        while(currentCol >= 0 && currentRow <= rows) {
            if (target == matrix[currentRow][currentCol]) {
                return true;
            } else if (target < matrix[currentRow][currentCol]) {
                currentCol--;
            } else if (target > matrix[currentRow][currentCol]) {
                currentRow++;
            }
        }
        return false;
    }
}
