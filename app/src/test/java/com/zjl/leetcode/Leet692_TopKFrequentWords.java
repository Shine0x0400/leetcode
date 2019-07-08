package com.zjl.leetcode;

import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 自己实现了最小堆和Trie树，其实可以直接利用java现有组件：HashMap和PriorityQueue
 *
 * @author zjl
 * @date 2019-07-07
 */
public class Leet692_TopKFrequentWords {

    /**
     * 使用现有Java API
     */
    public List<String> topKFrequentWithJavaApi(String[] words, int k) {
        final HashMap<String, Integer> frequency = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            frequency.put(words[i], frequency.getOrDefault(words[i], 0) + 1);
        }

        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return !frequency.get(o1).equals(frequency.get(o2))
                        ? frequency.get(o1) - frequency.get(o2)
                        : o2.compareTo(o1);
            }
        });

        for (String word : frequency.keySet()) {
            queue.add(word);
            if (queue.size() > k) {
                queue.remove();
            }
        }

        LinkedList<String> ans = new LinkedList<>();
        while (!queue.isEmpty()) {
            ans.addFirst(queue.remove());
        }

        return ans;
    }

    @Test
    public void test() {
        List<String> list = topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2);
        System.out.println(list);
    }

    private TrieNode[] topK;
    // 已在堆中的元素个数
    private int count;
    private int k;

    public List<String> topKFrequent(String[] words, int k) {


        TrieNode root = generateTrie(words);

        // 最小堆
        topK = new TrieNode[k + 1];
        count = 0;
        this.k = k;
        // 先序遍历trie
        traverseTrie(root);

        LinkedList<String> ans = new LinkedList<>();
        while (count > 0) {
            TrieNode min = deleteHeap();
            ans.addFirst(min.str);
        }

        return ans;
    }

    private TrieNode deleteHeap() {
        if (count <= 0) {
            throw new IllegalStateException("empty heap");
        }

        TrieNode res = topK[1];
        TrieNode last = topK[count--];

        int idx = 1;
        while (idx <= count) {
            int lc = idx << 1;
            int rc = lc + 1;

            if (lc > count) {
                break;
            }

            int minChild = rc > count ? lc : smallerThanOther(topK[lc], topK[rc]) ? lc : rc;
            if (smallerThanOther(last, topK[minChild])) {
                break;
            }

            topK[idx] = topK[minChild];
            idx = minChild;
        }
        topK[idx] = last;


        return res;
    }

    private void traverseTrie(TrieNode root) {
        if (root == null) {
            return;
        }

        if (root.count > 0) {
            insertHeap(root);
        }

        for (int i = 0; i < root.nodes.length; i++) {
            traverseTrie(root.nodes[i]);
        }

    }

    private void insertHeap(TrieNode node) {

        // 最小堆还未构建成
        if (count < k) {
            count++;

            int idx = count;
            while (idx >> 1 > 0 && smallerThanOther(node, topK[idx >> 1])) {
                topK[idx] = topK[idx >> 1];
                idx >>= 1;
            }
            topK[idx] = node;

        } else { // 最小堆已构成

            // 比堆顶元素要大
            if (!smallerThanOther(node, topK[1])) {

                // 从上到下调整堆
                int idx = 1;
                while (idx <= k) {
                    int lc = idx << 1;
                    int rc = lc + 1;
                    if (lc > k) {
                        break;
                    }
                    int minChild = rc > k ? lc : (smallerThanOther(topK[lc], topK[rc]) ? lc : rc);

                    if (smallerThanOther(node, topK[minChild])) {
                        break;
                    }

                    topK[idx] = topK[minChild];
                    idx = minChild;
                }

                topK[idx] = node;
            }

        }
    }

    // 比较self是否比other更小
    private boolean smallerThanOther(TrieNode self, TrieNode other) {
        if (self.count < other.count) {
            return true;
        }

        if (self.count > other.count) {
            return false;
        }
        return self.str.compareTo(other.str) >= 0;
    }

    private TrieNode generateTrie(String[] words) {
        TrieNode root = new TrieNode(), p;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            p = root;
            for (int j = 0; j < word.length(); j++) {
                if (p.nodes[word.charAt(j) - 'a'] == null) {
                    p.nodes[word.charAt(j) - 'a'] = new TrieNode();
                }

                p = p.nodes[word.charAt(j) - 'a'];
            }
            p.str = word;
            p.count++;
        }
        return root;
    }

    private static class TrieNode {
        private int count;
        private String str;
        private TrieNode[] nodes = new TrieNode[26];
    }
}
