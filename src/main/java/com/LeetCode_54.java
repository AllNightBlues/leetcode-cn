/**
 * @(#) LeetCode_54.java 1.0 2022-10-11
 * Copyright (c) 2022, AllNightBlues. ALL right reserved.
 * AllNightBlues PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LeetCode_54
 * @description:
 * @AUTHOR AllNightBlues
 * @Date 2022/10/11 21:06
 * @Version 1.0
 **/
public class LeetCode_54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return list;
        }
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int plies = 0;

        int count = (Math.min(rowLength, colLength) + 1) / 2;
        while (plies < count) {
            for (int j = plies; j < colLength - plies; j++) {
                list.add(matrix[plies][j]);
            }

            for (int j = plies + 1; j < rowLength - plies; j++) {
                list.add(matrix[j][colLength - 1 - plies]);
            }

            for (int j = (colLength - 1) - (plies + 1); j >= plies && (rowLength - 1 - plies != plies); j--) {
                list.add(matrix[(rowLength - 1) - plies][j]);
            }

            for (int j = (rowLength - 1) - (plies + 1); j >= plies + 1 && (colLength - 1 - plies != plies); j--) {
                list.add(matrix[j][plies]);
            }
            plies++;
        }
        return list;
    }
}
