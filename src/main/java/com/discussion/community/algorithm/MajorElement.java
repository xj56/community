package com.discussion.community.algorithm;

/**
 * 主要元素 LeetCode
 * <p>
 * 使用摩尔投票法
 *
 * @author jie
 */
public class MajorElement {

    public int majorityElement(int[] nums) {
        int res = -1;
        int count = 0;
        //核心就是抵消不相同的数字
        for (int num : nums) {
            if (count == 0) {
                res = num;
            }
            if (num == res) {
                count++;
            } else {
                count--;
            }
        }
        //判断剩余下来的数字的数量
        count = 0;
        for (int num : nums) {
            if (num == res) {
                count++;
            }
        }
        return count * 2 > nums.length ? res : -1;
    }
}
