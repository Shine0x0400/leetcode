package com.zjl.leetcode;

import org.junit.Test;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 *
 * @author zjl
 * @date 2019-06-07
 */
public class Leet6_ZigZagConversion {
    @Test
    public void test() {
        String result = new Leet6_ZigZagConversion().convert("cbba", 4);
        System.out.println(result);
    }

    public String convert(String s, int numRows) {

        int length = s.length();
        if (length < 2 || numRows < 2) {
            return s;
        }

        char[] conversion = new char[length];
        int x = 0;

        // iterator rows
        for (int i = 0; i < numRows; i++) {
            int j = i;

            if (j < length) {
                conversion[x++] = s.charAt(j);

                while (j < length) {

                    // 向下走
                    int jump = (numRows - 1 - i) << 1;
                    j += jump;
                    if (jump > 0 && j < length) {
                        conversion[x++] = s.charAt(j);
                    }

                    // 向上走
                    jump = i << 2;
                    j += jump;
                    if (jump > 0 && j < length) {
                        conversion[x++] = s.charAt(j);
                    }
                }
            }
        }

        return new String(conversion);
    }
}
