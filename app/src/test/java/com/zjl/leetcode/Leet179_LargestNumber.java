package com.zjl.leetcode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zjl
 * @date 2019-07-17
 */
public class Leet179_LargestNumber {

    public String largestNumber(int[] nums) {
        List<String>[] map = new List[10];

        for (int i = 0; i < nums.length; i++) {
            String item = String.valueOf(nums[i]);

            int beginNumber = item.charAt(0) - '0';
            if (map[beginNumber] == null) {
                map[beginNumber] = new LinkedList<>();
            }
            map[beginNumber].add(item);
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            if (map[i] != null) {
                map[i].sort(new Comparator<String>() {
                    @Override
                    public int compare(String s1, String s2) {
                        if (s1.length() == s2.length()) {
                            return s2.compareTo(s1);
                        }

                        return (s2 + s1).compareTo(s1 + s2);
                    }
                });

                for (String str : map[i]) {
                    builder.append(str);
                }
            }
        }

        if (builder.length() > 0 && builder.charAt(0) == '0') {
            return "0";
        }

        return builder.toString();
    }
}
