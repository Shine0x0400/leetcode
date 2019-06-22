package com.zjl.leetcode;

import com.zjl.leetcode.datastructure.TreeNode;

/**
 * @author zjl
 * @date 2019-06-23
 */
public class Leet98_ValidateBinarySearchTree {

    // BST inorder-traversal is in increasing order
    public boolean isValidBST(TreeNode root) {
        int pre = 0;
        boolean init = false;

        // Morris Traversal
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode rightMost = cur.left;
                while (rightMost.right != null) {
                    rightMost = rightMost.right;
                }

                rightMost.right = cur;
                TreeNode tmp = cur.left;
                cur.left = null;
                cur = tmp;
            } else {
                if (init && cur.val <= pre) {
                    return false;
                }

                pre = cur.val;
                init = true;
                cur = cur.right;
            }
        }

        return true;
    }
}
