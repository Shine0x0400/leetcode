package com.zjl.leetcode;

/**
 * @author zjl
 * @date 2019-07-03
 */
public class Leet116_PopulatingNextRightPointersInEachNode {

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Node preHead = root;

        // 只要有下一层就继续
        while (preHead.left != null) {

            Node p = preHead;
            while (p != null) {
                p.left.next = p.right;
                if (p.next != null) {
                    p.right.next = p.next.left;
                }

                p = p.next;
            }

            preHead = preHead.left;
        }

        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
