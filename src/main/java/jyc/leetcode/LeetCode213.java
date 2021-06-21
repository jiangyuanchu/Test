package jyc.leetcode;

import jyc.annotation.QuickStart;
import jyc.aop.LeetCodeBase;
import jyc.utils.LeetCodeQuickStart;

/**
 * 打家劫舍Ⅱ
 * 动态规划
 *
 * @see LeetCode198
 */
public class LeetCode213 implements LeetCodeBase {

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

        return Math.max(dp(nums, 0, nums.length - 2), dp(nums, 1, nums.length - 1));
    }

    private int dp(int nums[], int start, int end){
        int first = nums[start], second = Math.max(nums[start], nums[start + 1]);
        for(int i = start + 2; i < nums.length; i++){
            int t = second;
            second = Math.max(second, first + nums[i]);
            first = t;
        }
        return second;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(LeetCodeQuickStart.quickStart(LeetCode213.class, (Object) new int[]{2,3,2}));
    }


    @Override
    public void run(Object object) {

    }

}
