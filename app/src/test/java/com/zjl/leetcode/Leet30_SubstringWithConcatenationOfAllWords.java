package com.zjl.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author zjl
 * @date 2019-08-08
 */
public class Leet30_SubstringWithConcatenationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> ans = new ArrayList<>();

        if (words == null || words.length == 0 || s == null || s.length() < words[0].length()) {
            return ans;
        }

        Map<String, Integer> map = new HashMap<>();
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        int length = words[0].length();
        for (int i = 0; i < length; i++) {
            int start = i, end = start;
            Queue<String> queue = new LinkedList<>();

            while (start + length <= s.length()) {

                // increase window
                while (end + length <= s.length()) {
                    String sub = s.substring(end, end + length);
                    Integer remain = map.get(sub);

                    if (remain != null && remain > 0) {
                        queue.offer(sub);
                        map.put(sub, remain - 1);
                        end += length;
                    } else {
                        break;
                    }
                }

                // check window
                if (queue.size() == words.length) {
                    ans.add(start);
                }

                // decrease window
                boolean match = false;
                while (queue.size() > 0) {
                    String poll = queue.poll();
                    start += length;
                    map.put(poll, map.get(poll) + 1);

                    if (end + length <= s.length() && poll.equals(s.substring(end, end + length))) {
                        match = true;
                        break;
                    }
                }

                if (!match) {
                    start = end = end + length;
                }
            }

        }

        return ans;
    }

    // 重操旧业
//    public List<Integer> findSubstring(String s, String[] words) {
//        List<Integer> result = new ArrayList<>();
//        int len = words[0].length();
//
//        for (int b = 0; b < len; b++) {
//            List<String> list = new ArrayList<>(Arrays.asList(words));
//
//            int i = b, j = b;
//
//            while (!list.isEmpty() && j + len <= s.length()) {
//                String substring = s.substring(j, j + len);
//                if (list.contains(substring)) {
//                    list.remove(substring);
//                    j += len;
//
//                    if (list.isEmpty()) {
//                        result.add(i);
//
//                        if (j + len <= s.length()) {
//                            list.add(s.substring(i, i + len));
//                            i += len;
//                        }
//                    }
//
//                } else {
//                    if (i < j) {
//                        list.add(s.substring(i, i + len));
//                    }
//                    i += len;
//
//                    if (j < i) {
//                        j = i;
//                    }
//                }
//            }
//
//
//
//        }
//
//        return result;
//    }
}
