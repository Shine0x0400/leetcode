package com.zjl.leetcode;

import java.util.Stack;

/**
 * @author zjl
 * @date 2019-07-14
 */
public class Leet150_EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {

        Stack<Long> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            long d1, d2;
            switch (token) {
                case "+":
                    d1 = stack.pop();
                    d2 = stack.pop();
                    stack.push(d2 + d1);
                    break;
                case "-":
                    d1 = stack.pop();
                    d2 = stack.pop();
                    stack.push(d2 - d1);
                    break;
                case "*":
                    d1 = stack.pop();
                    d2 = stack.pop();
                    stack.push(d2 * d1);
                    break;
                case "/":
                    d1 = stack.pop();
                    d2 = stack.pop();
                    stack.push(d2 / d1);
                    break;
                default:
                    stack.push(Long.valueOf(token));
                    break;
            }
        }

        return stack.pop().intValue();
    }
}
