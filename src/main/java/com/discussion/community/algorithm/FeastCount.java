package com.discussion.community.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 大餐统计
 *
 * @author jie
 */
public class FeastCount {

    public int countPairs(int[] deliciousness) {
        int mod = (int) (Math.pow(10, 9) + 7);
        int res = 0;
        int max = 0;
        for (int i : deliciousness) {
            max = Math.max(i, max);
        }
        Map<Integer, Integer> map = new HashMap<>(deliciousness.length);
        //sum 最大不会超过最大值的2倍
        int maxSum = max * 2;
        for (int i : deliciousness) {
            //以最大值的2倍为界进行判断
            for (int sum = 1; sum <= maxSum; sum <<= 1) {
                int count = map.getOrDefault(sum - i, 0);
                res = (res + count) % mod;
            }
            //保存出现的数字和次数
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        return res;
    }
}
