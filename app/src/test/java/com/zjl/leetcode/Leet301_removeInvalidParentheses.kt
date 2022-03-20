package com.zjl.leetcode

/**
 *
 *
 * @author zjl
 * @date  2022/4/7
 */
class Leet301_removeInvalidParentheses {
    var ans = hashSetOf<String>()
    var deleteMin = 20

    fun removeInvalidParentheses(s: String): List<String> {
        backtrack(s, ptr = 0, leftParenthesesCount = 0, delete = 0, content = "")
        return ans.toList()
    }

    private fun backtrack(s: String, ptr: Int, leftParenthesesCount: Int, delete: Int, content: String) {
        if (ptr == s.length) {
            if (leftParenthesesCount != 0) {
                return
            }
            if (delete < deleteMin) {
                deleteMin = delete
                ans.clear()
                ans.add(content)
            } else if (delete == deleteMin) {
                ans.add(content)
            }
            return
        }

        when (val c = s[ptr]) {
            '(' -> {
                // 不删的情况
                backtrack(s, ptr + 1, leftParenthesesCount + 1, delete, content + c)
                // 删掉的情况
                backtrack(s, ptr + 1, leftParenthesesCount, delete + 1, content)
            }
            ')' -> {
                if (leftParenthesesCount <= 0) {
                    // 必须删掉的情况
                    backtrack(s, ptr + 1, leftParenthesesCount, delete + 1, content)
                } else {
                    // 不删的情况
                    backtrack(s, ptr + 1, leftParenthesesCount - 1, delete, content + c)
                    // 删掉的情况
                    backtrack(s, ptr + 1, leftParenthesesCount, delete + 1, content)
                }
            }
            else -> {
                backtrack(s, ptr + 1, leftParenthesesCount, delete, content + c)
            }
        }
    }
}