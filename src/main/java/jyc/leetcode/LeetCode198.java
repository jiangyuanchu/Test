package jyc.leetcode;

import jyc.annotation.QuickStart;
import jyc.aop.LeetCodeBase;
import jyc.utils.LeetCodeQuickStart;

import java.util.Arrays;

/**
 * 打家劫舍Ⅰ
 * 动态规划
 *
 * @see LeetCode213
 */
public class LeetCode198 implements LeetCodeBase {

    @QuickStart
    public int rob(int[] nums) {
        int[] maxSign = new int[nums.length];
        if(nums.length < 2){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        maxSign[0] = nums[0];
        maxSign[1] = nums[1];
        for(int i = 2; i < nums.length; i++){
            int max = 0;
            for(int j = i - 2; j < i - 1; j++){
                if(nums[i] + maxSign[j] > max){
                    max = nums[i] + maxSign[j];
                }
            }
            maxSign[i] = max;
        }
        return Math.max(maxSign[maxSign.length - 1], maxSign[maxSign.length - 2]);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(LeetCodeQuickStart.quickStart(LeetCode198.class, (Object) new int[]{2,7,9,3,1}));
    }


    @Override
    public void run(Object object) {

    }

}
