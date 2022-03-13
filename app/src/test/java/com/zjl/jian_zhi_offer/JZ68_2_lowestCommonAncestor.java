package com.zjl.jian_zhi_offer;

import com.zjl.leetcode.datastructure.TreeNode;

/**
 * @author zjl
 * @date 2022/3/14
 */
class JZ68_2_lowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        return l == null ? r : (r == null ? l : root);
    }
}
