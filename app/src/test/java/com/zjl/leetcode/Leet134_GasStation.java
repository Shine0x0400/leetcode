package com.zjl.leetcode;

/**
 * @author zjl
 * @date 2019-07-04
 */
public class Leet134_GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 1) {
            return gas[0] >= cost[0] ? 0 : -1;
        }

        for (int i = 0; i < gas.length; i++) {

            int remain = 0;
            if (gas[i] >= cost[i]) {
                int j = i + 1;
                if (j == gas.length) {
                    j = 0;
                }
                remain = gas[i] - cost[i];

                while (j != i && remain + gas[j] >= cost[j]) {
                    remain = remain + gas[j] - cost[j];

                    j++;
                    if (j == gas.length) {
                        j = 0;
                    }
                }

                if (j == i) {
                    return i;
                }
            }
        }

        return -1;
    }
}
