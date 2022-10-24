/**
 * @(#) LeetCode_208.java 1.0 2022-10-24
 * Copyright (c) 2022, AllNightBlues. ALL right reserved.
 * AllNightBlues PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com;

/**
 * @ClassName LeetCode_208
 * @description:
 * @AUTHOR AllNightBlues
 * @Date 2022/10/24 09:43
 * @Version 1.0
 **/
public class LeetCode_208 {

    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    class Trie {

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            insertChar(word, 0, root);
        }

        private void insertChar(String word, int index, TrieNode currNode) {
            if (index == word.length()) {
                currNode.isEnd = true;
                return;
            }
            int charIndex = word.charAt(index) - 'a';
            if (currNode.children[charIndex] == null) {
                currNode.children[charIndex] = new TrieNode();
            }
            insertChar(word, index + 1, currNode.children[charIndex]);
        }

        public boolean search(String word) {
            return searchChar(false, word, 0, root);
        }

        private boolean searchChar(boolean isPrefix, String word, int index, TrieNode currNode) {
            if (index == word.length()) {
                return isPrefix || currNode.isEnd;
            }
            int charIndex = word.charAt(index) - 'a';
            if (currNode.children[charIndex] == null) {
                return false;
            }
            return searchChar(isPrefix, word, index + 1, currNode.children[charIndex]);
        }

        public boolean startsWith(String prefix) {
            return searchChar(true, prefix, 0, root);
        }
    }
}
