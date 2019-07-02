package com.zjl.leetcode;

import java.util.Stack;

/**
 * @author zjl
 * @date 2019-07-02
 */
public class Leet84_LargestRectangleInHistogram {


    public int largestRectangleArea(int[] heights) {

        int max = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < heights.length; i++) {

            // 递增，入栈
            // 对于i和stack.peek()柱高度相等的情况，i的矩形肯定大于stack.peek()的矩形，所以先出栈前边的，然后计算i不会丢失最大值
            if (stack.peek() == -1 || heights[stack.peek()] < heights[i]) {
                stack.push(i);
            } else {
                // 当前柱<=栈顶，出栈
                while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {

                    // 计算高度等于stack.peek()柱高度的矩形的面积
                    max = Math.max(max, heights[stack.pop()] * (i - stack.peek() - 1));
                }
                stack.push(i);
            }
        }

        while (stack.peek() != -1) {
            max = Math.max(max, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }


        return max;
    }
}
