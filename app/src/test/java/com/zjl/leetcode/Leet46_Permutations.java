package com.zjl.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zjl
 * @date 2019-06-28
 */
public class Leet46_Permutations {
    List<List<Integer>> result;

    // using Backtracking
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
//        if (nums.length == 0) {
//            return result;
//        }

        List<Integer> remain = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            remain.add(nums[i]);
        }

        List<Integer> current = new ArrayList<>();
        permuteInternal(current, remain);

        return result;

    }

    private void permuteInternal(List<Integer> current, List<Integer> remain) {
        if (remain.size() == 0) {
            result.add(current);
            return;
        }

        for (int i = 0; i < remain.size(); i++) {
            ArrayList<Integer> next = new ArrayList<>(current);
            ArrayList<Integer> remainNext = new ArrayList<>(remain);

            next.add(remainNext.remove(i));

            permuteInternal(next, remainNext);
        }
    }
}
