package com.zjl.leetcode;

import com.zjl.leetcode.datastructure.TreeNode;

/**
 * @author zjl
 * @date 2019-07-03
 */
public class Leet104_MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
