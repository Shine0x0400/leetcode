package com.zjl.leetcode;

/**
 * @author zjl
 * @date 2019-06-22
 */
public class Leet96_UniqueBinarySearchTreesCount {
    public int numTrees(int n) {
        if (n <= 0) {
            return 1;
        }

        // dp[i] 表示i对应的BST个数，或者说长度为i的BST的个数
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int len = 1; len <= n; len++) {

            // left child length
            for (int i = 0; i < len; i++) {
                dp[len] += (dp[i] * dp[len - i - 1]);
            }
        }

        return dp[n];
    }
}
