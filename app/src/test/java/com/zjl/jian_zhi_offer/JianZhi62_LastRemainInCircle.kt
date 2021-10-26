package com.zjl.jian_zhi_offer

/**
 * 约瑟夫环问题
 *
 * @author zjl
 * @date  2021/10/23
 */

fun lastRemaining(n: Int, m: Int): Int {
    if (n == 1) {
        return 0;
    }
    // f(n, m) = (m % n + f(n-1, m)) % n = (m + f(n-1, m)) % n
    return (m + lastRemaining(n - 1, m)) % n
}

// 将以上递归方法翻译成迭代
fun lastRemaining2(n: Int, m: Int): Int {
    var r = 0 // n==1时，结果是0

    for (i in 2..n) {
        // r的含义是: r = f(i, m)
        r = (m + r) % i
    }

    return r
}