/**
 * @(#) LeetCode_39.java 1.0 2022-11-09
 * Copyright (c) 2022, AllNightBlues. ALL right reserved.
 * AllNightBlues PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName LeetCode_39
 * @description:
 * @AUTHOR AllNightBlues
 * @Date 2022/11/09 09:43
 * @Version 1.0
 **/
public class LeetCode_39 {
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(candidates, 0, candidates.length, target, new ArrayList<Integer>(), res);
        return res;
    }

    private void backTrack(int[] candidates, int begin, int len, int target, ArrayList<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < len; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            path.add(candidates[i]);
            backTrack(candidates, i, len, target- candidates[i], path, res);
            path.remove(path.size() - 1);
        }
    }
}
