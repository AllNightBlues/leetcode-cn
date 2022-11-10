/**
 * @(#) LeetCode_46.java 1.0 2022-11-10
 * Copyright (c) 2022, AllNightBlues. ALL right reserved.
 * AllNightBlues PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LeetCode_46
 * @description:
 * @AUTHOR AllNightBlues
 * @Date 2022/11/10 14:43
 * @Version 1.0
 **/
public class LeetCode_46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int[] used = new int[nums.length];
        backTrack(result, nums, new ArrayList<Integer>(), used);
        return result;
    }

    private void backTrack(List<List<Integer>> result, int[] nums, ArrayList<Integer> path, int[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) continue;
            used[i] = 1;
            path.add(nums[i]);
            backTrack(result, nums, path, used);
            used[i] = 0;
            path.remove(path.size() - 1);
        }
    }


}
