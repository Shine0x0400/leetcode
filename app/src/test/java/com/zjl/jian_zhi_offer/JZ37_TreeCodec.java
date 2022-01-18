package com.zjl.jian_zhi_offer;

import com.zjl.leetcode.datastructure.TreeNode;
import java.util.LinkedList;

/**
 * @author dylannzhang
 * @date 2022/1/17
 */
class JZ37_TreeCodec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode n = queue.poll();
            if (n == null) {
                builder.append("n")
                        .append(",");
            } else {
                builder.append(n.val)
                        .append(",");

                queue.offer(n.left);
                queue.offer(n.right);
            }
        }

        // delete last ','
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        String[] split = data.split(",");
        int i = 0;

        TreeNode root = createNode(split[i++]);
        if (root != null) {
            queue.offer(root);
        }

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            TreeNode left = createNode(split[i++]);
            TreeNode right = createNode(split[i++]);
            cur.left = left;
            cur.right = right;

            if (left != null) {
                queue.offer(left);
            }
            if (right != null) {
                queue.offer(right);
            }
        }

        return root;
    }

    private TreeNode createNode(String s) {
        if ("n".equals(s)) {
            return null;
        }

        int v = Integer.parseInt(s);
        return new TreeNode(v);
    }
}
