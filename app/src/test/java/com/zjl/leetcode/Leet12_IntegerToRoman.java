package com.zjl.leetcode;

/**
 * @author zjl
 * @date 2019-06-26
 */
public class Leet12_IntegerToRoman {

    public String intToRoman(int num) {
        char[] code = {
                'M',
                'D',
                'C',
                'L',
                'X',
                'V',
                'I'
        };

        StringBuilder builder = new StringBuilder();
        int current = 1000;
        int i = 0;

        while (current >= 1) {
            int d = num / current;
            num = num % current;

            if (d != 0) {

                if (d < 4) {
                    for (int j = 0; j < d; j++) {
                        builder.append(code[i]);
                    }
                } else if (d == 4) {
                    builder.append(code[i])
                            .append(code[i - 1]);
                } else if (d < 9) {
                    builder.append(code[i - 1]);
                    for (int j = 5; j < d; j++) {
                        builder.append(code[i]);
                    }
                } else if (d == 9) {
                    builder.append(code[i])
                            .append(code[i - 2]);
                }
            }
            current /= 10;
            i += 2;
        }

        return builder.toString();
    }
}
