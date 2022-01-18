package com.zjl.jian_zhi_offer;

/**
 * @author dylannzhang
 * @date 2022/1/17
 */
class JZ36_TreeToDoublyList {
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }

        Node l = treeToDoublyList(root.left);
        Node r = treeToDoublyList(root.right);

        Node result = root;
        result.left = result;
        result.right = result;

        if (l != null) {
            result.left = l.left;
            result.right = l;

            l.left.right = result;
            l.left = result;

            result = l;
        }

        if (r != null) {
            Node tail = result.left;
            result.left.right = r;
            result.left = r.left;

            r.left.right = result;
            r.left = tail;
        }

        return result;
    }


    private static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
