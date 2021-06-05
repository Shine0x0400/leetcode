package com.zjl.leetcode;

import java.util.PriorityQueue;
import org.junit.Test;

/**
 * @author zjl
 * @date 2019-07-08
 */
public class Leet264_UglyNumber2 {

    @Test
    public void test() {
        System.out.println(nthUglyNumber(10));
    }

    // use PriorityQueue
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

    /**
     * https://leetcode.com/problems/ugly-number-ii/discuss/69362/O(n)-Java-solution
     *
     * The ugly-number sequence is 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, …
     * because every number can only be divided by 2, 3, 5, one way to look at the sequence is to split the sequence to three groups as below:
     *
     * (1) 1×2, 2×2, 3×2, 4×2, 5×2, …
     * (2) 1×3, 2×3, 3×3, 4×3, 5×3, …
     * (3) 1×5, 2×5, 3×5, 4×5, 5×5, …
     * We can find that every subsequence is the ugly-sequence itself (1, 2, 3, 4, 5, …) multiply 2, 3, 5.
     *
     * 每次从x2 x3 x5的列中，找出最小的一个数
     */
    public int nthUglyNumber2(int n) {
        int[] uglys = new int[n];
        uglys[0] = 1;

        int idx2 = 0, idx3 = 0, idx5 = 0;
        // ugly2 = uglys[idx2] * 2
        int ugly2 = 2, ugly3 = 3, ugly5 = 5;

        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(ugly2, ugly3), ugly5);
            uglys[i] = min;

            if (min == ugly2) {
                ugly2 = uglys[++idx2] * 2;
            }
            if (min == ugly3) {
                ugly3 = uglys[++idx3] * 3;
            }
            if (min == ugly5) {
                ugly5 = uglys[++idx5] * 5;
            }
        }

        return uglys[n - 1];
    }
}
