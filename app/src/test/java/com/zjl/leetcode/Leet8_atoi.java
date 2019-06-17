package com.zjl.leetcode;

/**
 * @author zjl
 * @date 2019-06-17
 */
public class Leet8_atoi {
    public int myAtoi(String str) {
        int result = 0;
        int i;
        for (i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                break;
            }
        }

        if (i == str.length()) {
            return result;
        }

        boolean negative = false;
        if (str.charAt(i) == '+') {
            i++;
        } else if (str.charAt(i) == '-') {
            negative = true;
            i++;
        }

        for (; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                int t = c - '0';

                // check overflow
                if (result != 0) {
                    if (result < 0 && result < (0x80000000 + t) / 10) {
                        return 0x80000000;
                    } else if (result > (0x7fffffff - t) / 10) {
                        return 0x7fffffff;
                    }
                }

                result = negative ? result * 10 - t : result * 10 + t;
            } else {
                break;
            }
        }


        return result;
    }
}
