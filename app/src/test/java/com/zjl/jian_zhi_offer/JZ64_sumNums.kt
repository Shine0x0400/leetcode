package com.zjl.jian_zhi_offer

/**
 *
 *
 * @author zjl
 * @date  2022/3/13
 */
class JZ64_sumNums {
    // 利用逻辑运算短路特性
    fun sumNums(n: Int): Int {
        var ans = n
        n == 0 || run {
            ans += sumNums(n - 1)
            false
        }
        return ans
    }

//    // (n+1)*n/2, 通过位运算实现乘法的思路
//    fun sumNums(n: Int): Int {
//        var a = n + 1
//        var b = n
//        var ans = 0
//        while (b != 0) {
//            if (b and 1 != 0) {
//                ans += a
//            }
//            b = b shr 1
//            a = a shl 1
//        }
//        return ans shr 1
//    }
}