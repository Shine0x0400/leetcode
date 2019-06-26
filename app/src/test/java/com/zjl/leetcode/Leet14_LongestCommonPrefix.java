package com.zjl.leetcode;

/**
 * @author zjl
 * @date 2019-06-26
 */
public class Leet14_LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 0; ; i++) {
            if (i >= strs[0].length()) {
                return builder.toString();
            }

            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return builder.toString();
                }
            }
            builder.append(c);
        }
    }
}
