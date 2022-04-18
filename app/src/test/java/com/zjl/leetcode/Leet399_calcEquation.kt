package com.zjl.leetcode

/**
 *
 *
 * @author zjl
 * @date  2022/4/16
 */
class Leet399_calcEquation {

    fun calcEquation(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {
        val uf = UnionFind(equations.size * 2)
        var id = 0
        val ids = hashMapOf<String, Int>()

        equations.forEachIndexed { i, list ->
            if (!ids.contains(list[0])) {
                ids[list[0]] = id++
            }
            if (!ids.contains(list[1])) {
                ids[list[1]] = id++
            }
            uf.union(ids[list[0]]!!, ids[list[1]]!!, values[i])
        }

        val ans = DoubleArray(queries.size)
        queries.forEachIndexed { i, list ->
            if (!ids.contains(list[0]) || !ids.contains(list[1])) {
                ans[i] = -1.0
                return@forEachIndexed
            }
            ans[i] = uf.isConnected(ids[list[0]]!!, ids[list[1]]!!)
        }
        return ans
    }

    class UnionFind(val n: Int) {
        private val parents = IntArray(n) {
            it
        }
        private val weights = DoubleArray(n) { 1.0 }

        // 增加边 a->b, 边权重v
        fun union(a: Int, b: Int, v: Double) {
            val rootA = find(a)
            val rootB = find(b)
            if (rootA == rootB) {
                return
            }
            parents[rootA] = parents[rootB]
            weights[rootA] = v * weights[b] / weights[a]
        }

        // 返回其root, 查找过程中同时压缩路径
        fun find(a: Int): Int {
            if (a == parents[a]) {
                return a
            }
            val root = find(parents[a])
            weights[a] *= weights[parents[a]]
            parents[a] = root
            return root
        }

        fun isConnected(a: Int, b: Int): Double {
            val p1 = find(a)
            val p2 = find(b)
            return if (p1 != p2) {
                -1.0
            } else {
                weights[a] / weights[b]
            }
        }
    }
}