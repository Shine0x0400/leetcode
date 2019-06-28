package com.zjl.leetcode;

/**
 * @author zjl
 * @date 2019-06-29
 */
public class Leet91_DecodeWays {

    // using DP
    public int numDecodings(String s) {

        // ways[i] represent the decoding ways of s.subString(i)
        int[] ways = new int[s.length()];

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                if (i == 0
                        || (s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2')) {
                    return 0;
                }
                ways[i] = 0;

                if (i == s.length() - 1) {
                    ways[i - 1] = 1;
                } else {
                    ways[i - 1] = ways[i + 1];
                }

                // skip one
                i--;

            } else {
                if (i == s.length() - 1) {
                    ways[i] = 1;
                } else {
                    ways[i] = ways[i + 1];

                    if (i <= s.length() - 2 && Integer.valueOf(s.substring(i, i + 2)) <= 26) {
                        if (i + 2 < ways.length) {
                            ways[i] += ways[i + 2];
                        } else {
                            ways[i] += 1;
                        }
                    }
                }
            }
        }

        return ways[0];
    }
}
