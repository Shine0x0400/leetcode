package com.zjl.leetcode

/**
 *
 *
 * @author zjl
 * @date  2022/4/17
 */
class Leet406_reconstructQueue {

    fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
        // 优先按照身高从高到低排序，相同身高的，再按照k从小到大排序
//        people.sortWith { a: IntArray?, b: IntArray? ->
//            if (a!![0] != b!![0]) {
//                b[0] - a[0]
//            } else {
//                a[1] - b[1]
//            }
//        }
        people.sortWith(object : Comparator<IntArray> {
            override fun compare(a: IntArray?, b: IntArray?): Int {
                return if (a!![0] != b!![0]) {
                    b[0] - a[0]
                } else {
                    a[1] - b[1]
                }
            }
        })
        val list = ArrayList<IntArray>()
        people.forEach {
            list.add(it[1], it)
        }
        return list.toTypedArray()
    }
}