package com.zjl.leetcode

import com.zjl.leetcode.datastructure.TreeNode
import java.util.*

/**
 *
 *
 * @author zjl
 * @date  2022/4/5
 */
fun main() {
    val codec = Leet297_Codec()
    val root = codec.deserialize("(x)4((x)-23(x))")
    val serialize = codec.serialize(root)
}

class Leet297_Codec {

    /**
     * 方法一：DFS
     */
    // Encodes a URL to a shortened URL.
    fun serialize1(root: TreeNode?): String {
        if (root == null) {
            return "null"
        }
        return "${root.`val`},${serialize1(root.left)},${serialize1(root.right)}"
    }

    // Decodes your encoded data to tree.
    fun deserialize1(data: String): TreeNode? {
        val split = LinkedList(data.split(","))
        return rdeserialize(split)
    }

    private fun rdeserialize(values: LinkedList<String>): TreeNode? {
        val first = values.first
        values.removeFirst()
        if (first == "null") {
            return null
        }
        val ans = TreeNode(first.toInt())
        ans.left = rdeserialize(values)
        ans.right = rdeserialize(values)
        return ans
    }

    /**
     * 方法2：根据node是否为空，序列化为()V()，或者x形式
     */
    // Encodes a URL to a shortened URL.
    fun serialize(root: TreeNode?): String {
        if (root == null) {
            return "x"
        }
        return "(${serialize(root.left)})${root.`val`}(${serialize(root.right)})"
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        return rdeserialize2(data, intArrayOf(0))
    }

    private fun rdeserialize2(data: String, ptr: IntArray): TreeNode? {
        if ('x' == data[ptr[0]]) {
            ptr[0]++
            return null
        }
        val ans = TreeNode(0)
        ptr[0]++ // skip '('
        ans.left = rdeserialize2(data, ptr)
        ptr[0]++ // skip ')'

        ans.`val` = parseValue(data, ptr)

        ptr[0]++ // skip '('
        ans.right = rdeserialize2(data, ptr)
        ptr[0]++ // skip ')'

        return ans
    }

    private fun parseValue(data: String, ptr: IntArray): Int {
        var sign = 1
        if (data[ptr[0]] == '-') {
            sign = -1
            ptr[0]++
        }
        var x = 0
        while (data[ptr[0]].isDigit()) {
            x = x * 10 + (data[ptr[0]++] - '0')
        }
        return sign * x
    }

//    /**
//     * 以下广度优先 层遍历，会超过内存限制
//     */
//    // Encodes a URL to a shortened URL.
//    fun serialize(root: TreeNode?): String {
//        if (root == null) {
//            return "null"
//        }
//        val builder = StringBuilder()
//        val queue = LinkedList<TreeNode?>()
//        val delimiter = TreeNode(-1)
//        queue.add(root)
//        queue.add(delimiter)
//        var moreLevel = false
//        while (queue.isNotEmpty()) {
//            val cur = queue.poll()
//            if (cur == delimiter) {
//                if (!moreLevel) {
//                    break
//                }
//                moreLevel = false
//                queue.add(delimiter)
//            } else {
//                builder.append(cur?.`val` ?: "null")
//                    .append(",")
//                queue.add(cur?.left)
//                queue.add(cur?.right)
//                if (cur?.left != null || cur?.right != null) {
//                    moreLevel = true
//                }
//            }
//        }
//        builder.deleteCharAt(builder.lastIndex)
//        return builder.toString()
//    }
//
//    // Decodes your encoded data to tree.
//    fun deserialize(data: String): TreeNode? {
//        val a = data.split(",")
//        if (a[0] == "null") {
//            return null
//        }
//        val ans = TreeNode(a[0].toInt())
//        val queue = LinkedList<TreeNode?>()
//        queue.add(ans)
//        var i = 1
//        while (queue.isNotEmpty()) {
//            if (i >= a.size) {
//                break
//            }
//            val cur = queue.poll()
//            val l = createNode(a[i++])
//            val r = createNode(a[i++])
//            cur?.left = l
//            cur?.right = r
//            queue.add(l)
//            queue.add(r)
//        }
//        return ans
//    }
//
//    private fun createNode(s: String): TreeNode? {
//        if ("null" == s) {
//            return null
//        }
//        return TreeNode(s.toInt())
//    }
}