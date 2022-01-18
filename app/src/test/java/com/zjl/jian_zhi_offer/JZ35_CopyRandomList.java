package com.zjl.jian_zhi_offer;

/**
 * @author dylannzhang
 * @date 2022/1/17
 */
class JZ35_CopyRandomList {
    /**
     * 复杂度分析
     *
     * 时间复杂度：O(n)，其中 nn 是链表的长度。我们只需要遍历该链表三次。
     * 空间复杂度：O(1)。注意返回值不计入空间复杂度。
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node p = head;
        while (p != null) {
            Node n = p.next;
            p.next = new Node(p.val);
            p.next.next = n;
            p.next.random = p.random;
            p = n;
        }

        p = head.next;
        while (p != null) {
            if (p.random != null) {
                p.random = p.random.next;
            }
            if (p.next != null) {
                p = p.next.next;
            } else {
                p = null;
            }
        }

        p = head;
        Node result = null;
        Node tail = null;
        while (p != null) {
            Node c = p.next;
            p.next = c.next;
            p = p.next;

            c.next = null;
            if (tail == null) {
                tail = c;
                result = c;
            } else {
                tail.next = c;
                tail = c;
            }
        }

        return result;
    }

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}

