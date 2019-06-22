package com.zjl.leetcode;

import com.zjl.leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zjl
 * @date 2019-06-22
 */
public class Leet95_UniqueBinarySearchTrees2 {

    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return Collections.emptyList();
        }

        List<TreeNode> list = getTreeNodesInternal(1, n);

        return list;
    }

    private List<TreeNode> getTreeNodesInternal(int first, int last) {
        List<TreeNode> list = new ArrayList<>(last - first + 1);
        if (first > last) {
            list.add(null);
            return list;
        }

        for (int i = first; i <= last; i++) {

            List<TreeNode> lefts = getTreeNodesInternal(first, i - 1);
            List<TreeNode> rights = getTreeNodesInternal(i + 1, last);

            for (TreeNode l : lefts) {
                for (TreeNode r : rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
            }

        }
        return list;
    }
}
