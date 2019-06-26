package com.zjl.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zjl
 * @date 2019-06-26
 */
public class Leet13_RomanToInteger {
    private static Map<String, Integer> map = new HashMap();

    static {
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);
    }

    public int romanToInt(String s) {
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1) {
                Integer v = map.get(s.substring(i, i + 2));
                if (v != null) {
                    res += v;
                    i++;
                    continue;
                }
            }

            res += map.get(s.substring(i, i + 1));
        }

        return res;
    }
}
