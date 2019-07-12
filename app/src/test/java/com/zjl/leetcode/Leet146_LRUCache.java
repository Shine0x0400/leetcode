package com.zjl.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zjl
 * @date 2019-07-12
 */
public class Leet146_LRUCache {
    @Test
    public void test() {
        LRUCache cache = new LRUCache(2 /* capacity */);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }

    private static class LRUCache {
        int size = 0;
        int capacity;
        Map<Integer, Node> map = new HashMap<>();
        Node head, tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }

            Node node = map.get(key);
            moveToHead(node);

            return node.value;
        }

        public void put(int key, int value) {
            if (map.get(key) != null) {
                map.get(key).value = value;
                moveToHead(map.get(key));
                return;
            }

            Node fresh = new Node(key, value);
            map.put(key, fresh);
            size++;

            if (head == null) {
                head = tail = fresh;
                return;
            }

            fresh.next = head;
            head.prev = fresh;
            head = fresh;

            if (size > capacity) {
                size--;
                map.remove(tail.key);
                tail.prev.next = null;
                tail = tail.prev;
            }
        }

        private void moveToHead(Node node) {
            if (head == node) {
                return;
            }

            if (tail == node) {
                tail = node.prev;
            }

            if (node.prev != null) {
                node.prev.next = node.next;
            }

            if (node.next != null) {
                node.next.prev = node.prev;
            }

            node.prev = null;
            node.next = head;
            head.prev = node;

            head = node;
        }


        private static class Node {
            int key;
            int value;
            Node next;
            Node prev;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
    }
}
