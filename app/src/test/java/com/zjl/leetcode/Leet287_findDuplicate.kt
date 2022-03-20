package com.zjl.leetcode

/**
 *
 *
 * @author zjl
 * @date  2022/4/4
 */
class Leet287_findDuplicate {

    // 方法一：二分
    fun findDuplicate(nums: IntArray): Int {
        var left = 1
        var right = nums.size - 1
        var ans = -1

        while (left <= right) {
            val mid = left + (right - left) / 2
            var cnt = nums.count { it <= mid }

            if (cnt <= mid) {
                left = mid + 1
            } else {
                ans = mid
                right = mid - 1
            }
        }
        return ans
    }

    // 方法二： 位运算
    fun findDuplicate2(nums: IntArray): Int {
        var ans = 0
        for (i in 0..31) {
            val bit = 1 shl i
            val c1 = nums.count { it and bit != 0 }
            val c2 = (1..nums.size - 1).count { it and bit != 0 }
            if (c1 > c2) {
                ans = ans or bit
            }
        }
        return ans
    }

    // 方法三： 快慢指针查找环入口
    fun findDuplicate3(nums: IntArray): Int {
        // nums中元素值，看做是next指针，即坐标i指向坐标nums[i]

        var slow = 0
        var fast = 0
        do {
            slow = nums[slow]
            fast = nums[nums[fast]]
        } while (slow != fast)

        slow = 0
        while (slow != fast) {
            slow = nums[slow]
            fast = nums[fast]
        }
        return slow
    }

}