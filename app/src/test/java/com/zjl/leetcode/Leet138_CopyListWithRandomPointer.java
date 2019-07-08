package com.zjl.leetcode;

/**
 * @author zjl
 * @date 2019-07-08
 */
public class Leet138_CopyListWithRandomPointer {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node p = head;
        while (p != null) {
            Node copy = new Node(p.val, p.next, p.random);
            p.next = copy;

            p = p.next.next;
        }

        p = head.next;
        while (p != null) {
            if (p.random != null) {
                p.random = p.random.next;
            }
            if (p.next != null) {
                p = p.next.next;
            } else {
                break;
            }
        }

        Node copyHead = new Node();
        Node cp = copyHead;

        p = head;
        while (p != null) {
            cp.next = p.next;
            cp = cp.next;

            p.next = p.next.next;
            p = p.next;
        }

        return copyHead.next;
    }

//    // 借助Map保存新旧映射占用空间太大了
//    Map<Node, Node> map;
//
//    public Node copyRandomList(Node head) {
//        map = new HashMap<>();
//        return copyRandomListInternal(head);
//    }
//
//    private Node copyRandomListInternal(Node head) {
//        if (head == null) {
//            return null;
//        }
//
//        if (map.containsKey(head)) {
//            return map.get(head);
//        }
//
//        Node clone = new Node(head.val, null, null);
//        map.put(head, clone);
//
//        clone.next = copyRandomListInternal(head.next);
//        clone.random = copyRandomListInternal(head.random);
//
//        return clone;
//    }

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

}
