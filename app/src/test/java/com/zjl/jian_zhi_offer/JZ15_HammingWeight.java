package com.zjl.jian_zhi_offer;

public class JZ15_HammingWeight {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += 1 & n;
            n >>>= 1;
        }

        return result;
    }
}
