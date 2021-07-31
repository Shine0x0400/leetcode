package com.zjl.leetcode;

/**
 * @author zjl
 * @date 2019-07-04
 */
public class Leet134_GasStation {

    /**
     * https://leetcode.com/problems/gas-station/discuss/42568/Share-some-of-my-ideas.
     * 1. 如果从A不能够到达B，A和B之间的任何站点，都无法到达B
     * 2. 如果gas总和不小于cost总和，一定有解(really?)
     * 证明第二点：
     * 将gas>=cost的站点，记为绿色，否则记为红色，相邻同颜色的站点可以合并。如果都是绿色，肯定有解。否则:
     * 最终合并完成后，绿色和红色个数相等，一定存在一个红色站点，可以被它的下一个绿色站点合并掉，因为gas总和不小于cost总和。
     * 一直合并同颜色和吞并弱的红色站点，最终会合并为只剩一个绿色站点.
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0, total = 0, remain = 0;
        for (int i = 0; i < gas.length; i++) {
            if ((remain = remain + gas[i] - cost[i]) < 0) { // start无法到达i+1，更新start到i+1
                start = i + 1;
                total += remain;
                remain = 0;
            }
        }

        return total + remain < 0 ? -1 : start;
    }

//    public int canCompleteCircuit(int[] gas, int[] cost) {
//        if (gas.length == 1) {
//            return gas[0] >= cost[0] ? 0 : -1;
//        }
//
//        for (int i = 0; i < gas.length; i++) {
//
//            int remain = 0;
//            if (gas[i] >= cost[i]) {
//                int j = i + 1;
//                if (j == gas.length) {
//                    j = 0;
//                }
//                remain = gas[i] - cost[i];
//
//                while (j != i && remain + gas[j] >= cost[j]) {
//                    remain = remain + gas[j] - cost[j];
//
//                    j++;
//                    if (j == gas.length) {
//                        j = 0;
//                    }
//                }
//
//                if (j == i) {
//                    return i;
//                }
//            }
//        }
//
//        return -1;
//    }
}
