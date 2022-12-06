/**
 * @(#) LeetCode_128.java 1.0 2022-11-28
 * Copyright (c) 2022, AllNightBlues. ALL right reserved.
 * AllNightBlues PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @ClassName LeetCode_128
 * @description:
 * @AUTHOR AllNightBlues
 * @Date 2022/11/28 16:48
 * @Version 1.0
 **/
public class LeetCode_128 {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;
        for (Integer num : set) {
            int cur = num;
            if (!set.contains(cur - 1)) {
                while (set.contains(cur + 1)) {
                    cur++;
                }
            }
            longest = Math.max(longest, cur - num + 1);
        }
        return longest;
    }

    public int longestConsecutive1(int[] nums) {
        ADT adt = new ADT(nums);
        int ans = 0;
        for (int num : nums) {
            if (adt.find(num + 1) != null) {
                adt.union(num, num + 1);
            }
        }
        for (int num : nums) {
            int right = adt.find(num);
            ans = Math.max(ans, right - num + 1);
        }
        return ans;
    }

    class ADT {
        private Map<Integer, Integer> parent;

        public ADT(int[] nums) {
            parent = new HashMap<>();
            for (int num : nums) {
                parent.put(num, num);
            }
        }

        public Integer find(int x) {
            if (!parent.containsKey(x)) {
                return null;
            }
            while (x != parent.get(x)) {
                parent.put(x, parent.get(parent.get(x)));
                x = parent.get(x);
            }
            return x;
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            parent.put(rootX, rootY);
        }
    }


}
