package jyc.leetcode;

import jyc.aop.LeetCodeBase;
import jyc.utils.ListNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode300 implements LeetCodeBase {

    public int lengthOfLIS(int[] nums) {
        if(nums.length <= 0){
            return 0;
        }
        int[] maxCount = new int[nums.length];
        maxCount[0] = 1;
        int max = 0;
        for(int i =  1; i < nums.length; i++){
            int ownMax = 1;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    ownMax = Math.max(maxCount[j] + 1, ownMax);
                }
            }
            maxCount[i] = ownMax;
        }
        for (int a : maxCount){
            if(max < a) max  = a;
        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode300 leetCode300 = new LeetCode300();
        System.out.println(leetCode300.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }


    @Override
    public void run(Object object) {

    }

}
