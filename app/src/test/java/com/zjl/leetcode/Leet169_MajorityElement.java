package com.zjl.leetcode;

import java.util.Arrays;

/**
 * @author zjl
 * @date 2019-06-23
 */
public class Leet169_MajorityElement {

//    public int majorityElement(int[] nums) {
//        return majorityElementInternal(nums, 0, nums.length - 1);
//    }
//
//    // Divide And Conquer
//    private int majorityElementInternal(int[] nums, int start, int end) {
//        if (start > end) {
//            return -1;
//        } else if (start == end) {
//            return nums[start];
//        }
//
//        int mid = (start + end) >> 1;
//        int leftMajority = majorityElementInternal(nums, start, mid);
//        int rightMajority = majorityElementInternal(nums, mid + 1, end);
//
//        if (leftMajority == rightMajority) {
//            return leftMajority;
//        }
//
//        int lcount = 0, rcount = 0;
//        for (int i = start; i <= end; i++) {
//            if (nums[i] == leftMajority) {
//                lcount++;
//            } else if (nums[i] == rightMajority) {
//                rcount++;
//            }
//        }
//
//        return lcount > rcount ? leftMajority : rightMajority;
//    }

    // Sort, the majority must occupy the length/2 index.
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }


    /**
     * 博耶-摩尔多数投票算法（英语：Boyer–Moore majority vote algorithm）,中文常作多数投票算法、摩尔投票算法等
     *
     * 《剑指Offer》中的解释
     * 遍历数组的时候保存两个值：一个是数组中的数字，另一个是次数。当我们遍历到下一个数字的时候，如果下一个数字和我们之前保存的数字相同，则次数加1；如果下一个数字和我们之前保存的数字不同，则次数减1。如果次数为零，那么需要保存下一个数字，并把次数设为1.由于我们要找的数字出现的次数比其他所有数字出现的次数之和还要多，那么要找的数字肯定是最后一次把次数设为1时的对应数字。
     *
     * LeetCode官方解释：
     * Intuition
     *
     * If we had some way of counting instances of the majority element as +1+1 and instances of any other element as -1−1, summing them would make it obvious that the majority element is indeed the majority element.
     *
     * Algorithm
     *
     * Essentially, what Boyer-Moore does is look for a suffix sufsuf of nums where suf[0]suf[0] is the majority element in that suffix. To do this, we maintain a count, which is incremented whenever we see an instance of our current candidate for majority element and decremented whenever we see anything else. Whenever count equals 0, we effectively forget about everything in nums up to the current index and consider the current number as the candidate for majority element. It is not immediately obvious why we can get away with forgetting prefixes of nums - consider the following examples (pipes are inserted to separate runs of nonzero count).
     *
     * [7, 7, 5, 7, 5, 1 | 5, 7 | 5, 5, 7, 7 | 7, 7, 7, 7]
     *
     * Here, the 7 at index 0 is selected to be the first candidate for majority element. count will eventually reach 0 after index 5 is processed, so the 5 at index 6 will be the next candidate. In this case, 7 is the true majority element, so by disregarding this prefix, we are ignoring an equal number of majority and minority elements - therefore, 7 will still be the majority element in the suffix formed by throwing away the first prefix.
     *
     * [7, 7, 5, 7, 5, 1 | 5, 7 | 5, 5, 7, 7 | 5, 5, 5, 5]
     *
     * Now, the majority element is 5 (we changed the last run of the array from 7s to 5s), but our first candidate is still 7. In this case, our candidate is not the true majority element, but we still cannot discard more majority elements than minority elements (this would imply that count could reach -1 before we reassign candidate, which is obviously false).
     *
     * Therefore, given that it is impossible (in both cases) to discard more majority elements than minority elements, we are safe in discarding the prefix and attempting to recursively solve the majority element problem for the suffix. Eventually, a suffix will be found for which count does not hit 0, and the majority element of that suffix will necessarily be the same as the majority element of the overall array.
     */
    public int majorityElement2(int[] nums) {
        int candidate = nums[0];
        for (int i = 0, count = 0; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
            }
            count += (nums[i] == candidate ? 1 : -1);
        }
        return candidate;
    }

}
