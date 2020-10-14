package com.zjl.leetcode;

/**
 * @author zjl
 * @date 2020-10-14
 */
public class Leet3_LongestSubstringWithoutRepeatingCharacters {

    // Sliding Window
    public int lengthOfLongestSubstring(String str) {
        if (str == null || "".equals(str)) {
            return 0;
        }

        int max = 1;

        // s, e两个指针，指向在e处结尾的最长子串的头和尾
        for (int s = 0, e = 1; e < str.length(); e++) {
            char c = str.charAt(e);
            int occur = str.indexOf(c, s);

            // 如果在[s, e)找到了重复的e处字符，s需要更新到新的头位置
            if (occur >= s && occur < e) {
                s = occur + 1;
            }

            max = Math.max(max, e - s + 1);
        }

        return max;
    }

//    // Sliding Window
//    public int lengthOfLongestSubstring(String s) {
//        if (s == null) {
//            return 0;
//        }
//
//        if (s.length() <= 1) {
//            return s.length();
//        }
//
//        int length = 1;
//
//        // s consists of English letters, digits, symbols and spaces,
//        // so we can use an ASCII 128 array handle all characters
//        int[] index = new int[128]; // ASCII 128
//        for (int i = 0; i < 128; i++) {
//            index[i] = -1;
//        }
//        index[s.charAt(0)] = 0;
//
//        // [i, j] 表示最长无重复子串
//        for (int i = 0, j = 1; j < s.length(); j++) {
//            // move i, until [i, j] doesn't include s[j].
//            i = Math.max(index[s.charAt(j)] + 1, i);
//
//            length = Math.max(length, j - i + 1);
//
//            index[s.charAt(j)] = j;
//        }
//
//        return length;
//    }
}
