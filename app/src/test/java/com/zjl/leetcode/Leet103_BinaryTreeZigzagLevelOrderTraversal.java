package com.zjl.leetcode;

import com.zjl.leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zjl
 * @date 2019-07-03
 */
public class Leet103_BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        Queue<TreeNode> current = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();

        if (root != null) {
            current.add(root);
        }

        boolean reverse = false;

        while (!current.isEmpty()) {
            LinkedList<Integer> level = new LinkedList<>();
            ans.add(level);
            while (!current.isEmpty()) {
                TreeNode node = current.remove();
                if (!reverse) {
                    level.addLast(node.val);
                } else {
                    level.addFirst(node.val);
                }

                if (node.left != null) {
                    next.add(node.left);
                }
                if (node.right != null) {
                    next.add(node.right);
                }
            }


            reverse = !reverse;

            Queue<TreeNode> tmp = current;
            current = next;
            next = tmp;
        }

        return ans;
    }
}
