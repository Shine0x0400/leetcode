package com.zjl.leetcode;

/**
 * @author zjl
 * @date 2019-06-27
 */
public class Leet28_ImplementStrStr {
    public int strStr(String haystack, String needle) {

        if (needle.isEmpty()) {
            return 0;
        }

        int last = haystack.length() - needle.length();
        for (int i = 0; i <= last; i++) {

            int ii = i;
            int j = 0;
            for (; j < needle.length(); j++, ii++) {
                if (haystack.charAt(ii) != needle.charAt(j)) {
                    break;
                }
            }

            if (j == needle.length()) {
                return i;
            }
        }

        return -1;
    }
}
