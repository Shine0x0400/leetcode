package com.zjl.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zjl
 * @date 2019-06-28
 */
public class Leet38_CountAndSay {

    public String countAndSay(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(1);

        for (int i = 2; i <= n; i++) {
            ArrayList<Integer> next = new ArrayList<>();

            Integer current = null;
            int count = 0;
            for (Integer num : list) {
                if (num != current) {
                    if (count > 0) {
                        next.add(count);
                        next.add(current);
                    }

                    current = num;
                    count = 1;
                } else {
                    count++;
                }
            }

            // don't forget the last number
            if (count > 0) {
                next.add(count);
                next.add(current);
            }

            list = next;
        }

        StringBuilder builder = new StringBuilder();
        for (int i :
                list) {
            builder.append(i);
        }
        return builder.toString();
    }
}
