package com.zjl.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zjl
 * @date 2019-06-29
 */
public class Leet56_MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0 || intervals.length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int index = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= intervals[index][1]) {
                intervals[index][1] = Math.max(intervals[index][1], intervals[i][1]);
            } else {
                intervals[++index] = intervals[i];
            }
        }

        return Arrays.copyOf(intervals, index + 1);
    }
}
