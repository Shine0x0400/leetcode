package com.zjl.leetcode;

import java.util.HashMap;

/**
 * @author zjl
 * @date 2019-07-16
 */
public class Leet166_FractionToRecurringDecimal {

    // 纸上写一下100/37的计算过程
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }

        if (denominator == 0) {
            return "";
        }

        boolean negative = (numerator ^ denominator) < 0;
        long numeratorL = Math.abs(((long) numerator));
        long denominatorL = Math.abs(((long) denominator));

        long quotient = numeratorL / denominatorL;
        long remainder = numeratorL % denominatorL;

        if (remainder == 0) {
            return quotient == 0 ? "0" : negative ? "-" + quotient : "" + quotient;
        }

        StringBuilder builder = new StringBuilder();
        if (negative) {
            builder.append("-");
        }
        builder.append(quotient).append(".");

        // remainder-index map
        HashMap<Long, Integer> map = new HashMap<>();

        while (remainder != 0) {

            Integer index = map.get(remainder);
            if (index != null) {
                // the begin index of the repeating part
                builder.insert(index, "(");
                builder.append(")");
                return builder.toString();
            }

            map.put(remainder, builder.length());
            quotient = remainder * 10 / denominatorL;
            remainder = remainder * 10 % denominatorL;
            builder.append(quotient);
        }

        return builder.toString();
    }
}
