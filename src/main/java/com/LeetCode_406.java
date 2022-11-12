/**
 * @(#) LeetCode_406.java 1.0 2022-11-12
 * Copyright (c) 2022, AllNightBlues. ALL right reserved.
 * AllNightBlues PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName LeetCode_406
 * @description:
 * @AUTHOR AllNightBlues
 * @Date 2022/11/12 10:27
 * @Version 1.0
 **/
public class LeetCode_406 {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o2[0] - o1[0];
            } else {
                return o1[1] - o2[1];
            }
        });
        List<int[]> answer = new ArrayList<>();
        for (int[] element : people) {
            answer.add(element[1], element);
        }
        return answer.toArray(new int[answer.size()][]);
    }
}
