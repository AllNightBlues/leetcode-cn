/**
 * @(#) Leetcode_215.java 1.0 2022-10-12
 * Copyright (c) 2022, AllNightBlues. ALL right reserved.
 * AllNightBlues PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com;

import java.util.PriorityQueue;

/**
 * @ClassName Leetcode_215
 * @description:
 * @AUTHOR AllNightBlues
 * @Date 2022/10/12 21:01
 * @Version 1.0
 **/
public class Leetcode_215 {

    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int left = 0;
        int right = len - 1;

        int target = len - k;

        while (true) {
            int index = partition(nums, left, right);
            if (index == target) {
                return nums[index];
            } else if (index < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
    }

    private static int partition(int[] array, int start, int end) {
        if (start == end) return start;
        int pivot = (int) (start + Math.random() * (end - start + 1));
        int zoneIndex = start - 1;
        swap(array, pivot, end);
        for (int i = start; i <= end; i++) {
            if (array[i] <= array[end]) {
                zoneIndex++;
                if (i > zoneIndex)
                    swap(array, i, zoneIndex);
            }
        }
        return zoneIndex;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > pq.peek()) {
                pq.poll();
                pq.offer(nums[i]);
            }
        }
        return pq.peek();
    }

    public int findKthLargest2(int[] nums, int k) {
        int len = nums.length;
        buildMaxHeap(nums, len);
        for (int i = nums.length - 1; i >= nums.length - k + 1 ; --i) {
            swap(nums, 0, i);
            --len;
            adjustHeap(nums, 0, len);
        }
        return nums[0];
    }

    private void adjustHeap(int[] array, int i, int heapSize) {
        int maxIndex = i;
        int left = 2 * i + 1;
        int right = 2 * (i + 1);
        if (left < heapSize && array[left] > array[maxIndex]) {
            maxIndex = left;
        }
        if (right < heapSize && array[right] > array[maxIndex] && array[right] > array[left]) {
            maxIndex = right;
        }
        if (maxIndex != i) {
            swap(array, maxIndex, i);
            adjustHeap(array, maxIndex, heapSize);
        }
    }

    private void buildMaxHeap(int[] array, int heapSize) {
        for (int i = (heapSize / 2 - 1); i >= 0; i--) {
            adjustHeap(array, i, heapSize);
        }
    }
}
