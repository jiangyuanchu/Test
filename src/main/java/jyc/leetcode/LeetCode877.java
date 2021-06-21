package jyc.leetcode;

import jyc.annotation.QuickStart;
import jyc.aop.LeetCodeBase;
import jyc.utils.LeetCodeQuickStart;

import java.util.Arrays;

public class LeetCode877 implements LeetCodeBase {

    @QuickStart
    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }


        }
        return new int[0];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.toString((int[]) LeetCodeQuickStart.quickStart(LeetCode877.class, new int[]{2, 7, 11, 15}, 18)));
//        System.out.println(System.currentTimeMillis());
    }


    @Override
    public void run(Object object) {

    }

}
