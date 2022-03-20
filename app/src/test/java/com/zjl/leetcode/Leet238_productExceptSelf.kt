package com.zjl.leetcode

/**
 *
 *
 * @author zjl
 * @date  2022/4/1
 */
class Leet238_productExceptSelf {
    // Space Complex: O(1)
    fun productExceptSelf(nums: IntArray): IntArray {
        val ans = IntArray(nums.size) {
            1
        }

        var prefixProduct = 1
        var postfixProduct = 1
        for (i in 1..nums.lastIndex) {
            prefixProduct *= nums[i - 1]
            ans[i] *= prefixProduct

            postfixProduct *= nums[nums.lastIndex - i + 1]
            ans[nums.lastIndex - i] *= postfixProduct
        }

        return ans
    }

    // Space Complex: O(n)
    fun productExceptSelf2(nums: IntArray): IntArray {
        val prefixProduct = IntArray(nums.size)
        val postfixProduct = IntArray(nums.size)
        prefixProduct[0] = 1
        postfixProduct[nums.lastIndex] = 1

        for (i in 1..nums.lastIndex) {
            prefixProduct[i] = prefixProduct[i - 1] * nums[i - 1]
            val post = nums.lastIndex - i
            postfixProduct[post] = postfixProduct[post + 1] * nums[post + 1]
        }

        return IntArray(nums.size) {
            prefixProduct[it] * postfixProduct[it]
        }
    }
}