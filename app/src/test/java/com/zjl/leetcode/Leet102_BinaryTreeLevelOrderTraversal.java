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
public class Leet102_BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        Queue<TreeNode> current = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();

        if (root != null) {
            current.add(root);
        }

        while (!current.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            ans.add(level);
            while (!current.isEmpty()) {
                TreeNode node = current.remove();
                level.add(node.val);

                if (node.left != null) {
                    next.add(node.left);
                }
                if (node.right != null) {
                    next.add(node.right);
                }
            }

            Queue<TreeNode> tmp = current;
            current = next;
            next = tmp;
        }

        return ans;
    }
}
