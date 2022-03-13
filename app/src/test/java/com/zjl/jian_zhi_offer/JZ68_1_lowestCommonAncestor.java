package com.zjl.jian_zhi_offer;

import com.zjl.leetcode.datastructure.TreeNode;

/**
 * @author zjl
 * @date 2022/3/14
 */
class JZ68_1_lowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int c = root.val;
        int mi = Math.min(p.val, q.val);
        int ma = Math.max(p.val, q.val);
        if (c >= mi && c <= ma) {
            return root;
        }

        if (c < mi) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return lowestCommonAncestor(root.left, p, q);
    }
}
