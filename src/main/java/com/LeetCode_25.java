/**
 * @(#) LeetCode_25.java 1.0 2022-10-16
 * Copyright (c) 2022, AllNightBlues. ALL right reserved.
 * AllNightBlues PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com;

/**
 * @ClassName LeetCode_25
 * @description:
 * @AUTHOR AllNightBlues
 * @Date 2022/10/16 17:52
 * @Version 1.0
 **/
public class LeetCode_25 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode begin;
        if (head == null || head.next == null || k == 1)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        begin = dummy;
        int i = 0;
        while (head != null) {
            i++;
            if (i % k == 0) {
                begin = reverse(begin, head.next);
                head = begin.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode preSubList, ListNode subListNext) {
        ListNode startNode = preSubList.next;
        ListNode nextNode = startNode.next;
        ListNode inPreNode = preSubList;
        while (startNode.next != subListNext) {
            startNode.next = nextNode.next;
            nextNode.next = inPreNode.next;
            inPreNode.next = nextNode;
            nextNode = startNode.next;
        }
        return startNode;
    }
}
