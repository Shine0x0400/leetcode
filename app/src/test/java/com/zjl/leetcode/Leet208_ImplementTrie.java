package com.zjl.leetcode;

/**
 * @author zjl
 * @date 2019-07-19
 */
public class Leet208_ImplementTrie {

    class Trie {
        private Node root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new Node();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {

            Node p = root;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (p.chars[i] == null) {
                    p.chars[i] = new Node();
                }
                p = p.chars[i];
            }
            p.wordCount++;

        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Node p = root;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (p.chars[i] == null) {
                    return false;
                }
                p = p.chars[i];
            }

            return p.wordCount > 0;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            Node p = root;
            for (char c : prefix.toCharArray()) {
                int i = c - 'a';
                if (p.chars[i] == null) {
                    return false;
                }
                p = p.chars[i];
            }

            return true;
        }

        class Node {
            Node[] chars = new Node[26];
            int wordCount = 0;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
