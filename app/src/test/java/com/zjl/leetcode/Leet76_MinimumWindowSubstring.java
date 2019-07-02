package com.zjl.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zjl
 * @date 2019-07-02
 */
public class Leet76_MinimumWindowSubstring {

    // using Sliding Window
    public String minWindow(String s, String t) {

        if (s.isEmpty() || t.isEmpty()) {
            return "";
        }

        int tlength = t.length();

        Map<Character, Integer> tOccurrenceCount = new HashMap<>();
        for (int i = 0; i < tlength; i++) {
            tOccurrenceCount.put(t.charAt(i),
                    tOccurrenceCount.getOrDefault(t.charAt(i), 0) + 1);
        }

        int require = tOccurrenceCount.size();
        int matched = 0;

        int[] ans = {0, 0, 0};
        int l = 0, r = 0;

        while (r < s.length()) {
            char sc = s.charAt(r++);
            if (tOccurrenceCount.containsKey(sc)) {
                int value = tOccurrenceCount.get(sc).intValue() - 1;
                tOccurrenceCount.put(sc, value);

                if (value == 0) {
                    matched++;
                }
            }

            while (matched == require) {
                if (ans[0] == 0 || r - l < ans[0]) {
                    ans[0] = r - l;
                    ans[1] = l;
                    ans[2] = r;

                    if (ans[0] == tlength) {
                        return s.substring(ans[1], ans[2]);
                    }
                }

                char pass = s.charAt(l++);
                if (tOccurrenceCount.containsKey(pass)) {
                    int value = tOccurrenceCount.get(pass) + 1;
                    tOccurrenceCount.put(pass, value);

                    if (value > 0) {
                        matched--;
                    }
                }
            }
        }

        return ans[0] == 0 ? "" : s.substring(ans[1], ans[2]);
    }

//    public String minWindow(String s, String t) {
//
//        if (s.isEmpty() || t.isEmpty()) {
//            return "";
//        }
//
//        Map<Character, Integer> tOccurrenceCount = new HashMap<>();
//        for (int i = 0; i < t.length(); i++) {
//            tOccurrenceCount.put(t.charAt(i),
//                    tOccurrenceCount.getOrDefault(t.charAt(i), 0) + 1);
//        }
//
//        Map<Character, Integer> slidingWindowOccurrenceCount = new HashMap<>();
//
//        int matchRequire = tOccurrenceCount.size();
//        int hasMatched = 0;
//
//        // {length, left, right}
//        int[] minWindow = {0, 0, 0};
//
//        int l = 0, r = 0;
//        while (r < s.length()) {
//
//            char sc = s.charAt(r);
//            slidingWindowOccurrenceCount.put(sc,
//                    slidingWindowOccurrenceCount.getOrDefault(sc, 0) + 1);
//            if (tOccurrenceCount.containsKey(sc) && tOccurrenceCount.get(sc).equals(slidingWindowOccurrenceCount.get(sc))) {
//                hasMatched++;
//            }
//
//            while (hasMatched == matchRequire) {
//                if (minWindow[0] == 0 || r - l + 1 < minWindow[0]) {
//                    minWindow[0] = r - l + 1;
//                    minWindow[1] = l;
//                    minWindow[2] = r;
//                }
//
//                char pass = s.charAt(l);
//                slidingWindowOccurrenceCount.put(pass, slidingWindowOccurrenceCount.get(pass) - 1);
//                if (tOccurrenceCount.containsKey(pass) && slidingWindowOccurrenceCount.get(pass) < tOccurrenceCount.get(pass)) {
//                    hasMatched--;
//                }
//
//                l++;
//            }
//
//            r++;
//        }
//
//        return minWindow[0] == 0 ? "" : s.substring(minWindow[1], minWindow[2] + 1);
//    }


}
