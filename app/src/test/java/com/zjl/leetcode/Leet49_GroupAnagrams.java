package com.zjl.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zjl
 * @date 2019-06-28
 */
public class Leet49_GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];

            int[] count = new int[26];
            Arrays.fill(count, 0);

            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder builder = new StringBuilder();
            for (int cnt : count) {
                builder.append("#");
                builder.append(cnt);
            }
            String key = builder.toString();

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
