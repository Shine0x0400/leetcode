package com.zjl.leetcode;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @author zjl
 * @date 2019-07-08
 */
public class Leet264_UglyNumber2 {

    @Test
    public void test() {
        System.out.println(nthUglyNumber(10));
    }


    public int nthUglyNumber(int n) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        queue.add(1L);

        int k = 0;
        Long min = null;
        while (k < n) {
            Long remove = queue.remove();
            if (!remove.equals(min)) {
                min = remove;
                k++;

                queue.add(min * 2);
                queue.add(min * 3);
                queue.add(min * 5);
            }
        }

        return min.intValue();
    }
}
