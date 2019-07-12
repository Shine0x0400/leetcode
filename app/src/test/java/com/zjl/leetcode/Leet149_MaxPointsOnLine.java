package com.zjl.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zjl
 * @date 2019-07-14
 */
public class Leet149_MaxPointsOnLine {
    public int maxPoints(int[][] points) {
        if (points.length <= 2) {
            return points.length;
        }

        int result = 0;

        for (int i = 0; i < points.length; i++) {
            int same = 0;
            // slope-count map
            Map<String, Integer> map = new HashMap<>();
            int max = 0;

            for (int j = i + 1; j < points.length; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                if (dx == 0 && dy == 0) {
                    same++;
                    continue;
                }

                int gcd = calculateGCD(dx, dy);
                dx /= gcd;
                dy /= gcd;
                String slope = dy + "/" + dx;
                int count = map.getOrDefault(slope, 0) + 1;
                map.put(slope, count);

                max = Math.max(max, count);
            }

            result = Math.max(result, same + 1 + max);
        }

        return result;
    }

    // 求最大公约数, greatest common divisor
    private int calculateGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return calculateGCD(b, a % b);
    }

}
