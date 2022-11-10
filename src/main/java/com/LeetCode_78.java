/**
 * @(#) LeetCode_78.java 1.0 2022-11-10
 * Copyright (c) 2022, AllNightBlues. ALL right reserved.
 * AllNightBlues PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LeetCode_78
 * @description:
 * @AUTHOR AllNightBlues
 * @Date 2022/11/10 17:02
 * @Version 1.0
 **/
public class LeetCode_78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(0, nums, res, new ArrayList<Integer>());
        return res;
    }

    private void backTrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backTrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
