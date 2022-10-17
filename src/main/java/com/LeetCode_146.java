/**
 * @(#) LeetCode_146.java 1.0 2022-10-16
 * Copyright (c) 2022, AllNightBlues. ALL right reserved.
 * AllNightBlues PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com;


import java.util.HashMap;

/**
 * @ClassName LeetCode_146
 * @description:
 * @AUTHOR AllNightBlues
 * @Date 2022/10/16 16:26
 * @Version 1.0
 **/
public class LeetCode_146 {

    class LRUCache {

        class LinkedNode {
            int key;
            int value;
            LinkedNode pre;
            LinkedNode next;
        }

        private void addNode(LinkedNode node) {
            node.pre = head;
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
        }

        private void removeNode(LinkedNode node) {
            LinkedNode pre = node.pre;
            LinkedNode post = node.next;
            pre.next = post;
            post.pre = pre;
        }

        private void moveToHead(LinkedNode node) {
            this.removeNode(node);
            this.addNode(node);
        }

        private LinkedNode removeTail() {
            LinkedNode res = tail.pre;
            this.removeNode(res);
            return res;
        }

        private HashMap<Integer, LinkedNode> cache = new HashMap<>();
        private LinkedNode head,tail;

        public LRUCache(int capacity) {
            head = new LinkedNode();
            head.key = capacity;
            head.value = 0;
            head.pre = null;
            tail = new LinkedNode();
            tail.next = null;
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            LinkedNode node = cache.get(key);
            if (node != null) {
                this.moveToHead(node);
                return node.value;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            LinkedNode node = cache.get(key);
            if (node != null) {
                node.value = value;
                this.moveToHead(node);
            } else {
                LinkedNode newNode = new LinkedNode();
                newNode.key = key;
                newNode.value = value;
                this.cache.put(key, newNode);
                this.addNode(newNode);
                ++head.value;
                if (head.value > head.key) {
                    LinkedNode tail = this.removeTail();
                    this.cache.remove(tail.key);
                    --head.value;
                }
            }
        }
    }
}
