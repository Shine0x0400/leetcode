package com.zjl.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zjl
 * @date 2019-06-26
 */
public class Leet17_LetterCombinationsOfPhoneNumber {
    private static char[][] code = {
            {'a', 'b', 'c'},// 2
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'},
    };

    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.isEmpty()) {
            return Collections.emptyList();
        }

        List<String> result = new ArrayList<>();
        result.add("");

        for (int i = 0; i < digits.length(); i++) {
            int idx = digits.charAt(i) - '2';
            for (int j = result.size() - 1; j >= 0; j--) {
                String remove = result.remove(j);
                for (char c :
                        code[idx]) {
                    result.add(remove + c);
                }
            }
        }

        return result;
    }
}
