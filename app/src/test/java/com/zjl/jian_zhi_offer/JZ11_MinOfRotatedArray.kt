package com.zjl.jian_zhi_offer

class JZ11_MinOfRotatedArray {
//    fun minArray(numbers: IntArray): Int {
//        val f = numbers[0]
//        numbers.forEach {
//            if (it < f) {
//                return it
//            }
//        }
//
//        return f
//    }

    // 使用二分查找
    fun minArray(numbers: IntArray): Int {
        var low = 0
        var high = numbers.lastIndex
        while (low < high) {
            val middle = low + (high - low) / 2
            when {
                numbers[middle] < numbers[high] -> high = middle
                numbers[middle] > numbers[high] -> low = middle + 1
                else -> high--
            }
        }

        return numbers[low]
    }
}