package jyc.leetcode;

import jyc.annotation.QuickStart;
import jyc.aop.LeetCodeBase;
import jyc.utils.LeetCodeQuickStart;

import java.util.Arrays;

public class LeetCode153 implements LeetCodeBase {

    @QuickStart
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int middle = (low + high) / 2;
        while(low < high - 1){
            if(nums[middle] > nums[high]){
                low = middle;
            }
            if(nums[middle] < nums[high]){
                high = middle;
            }
            middle = (low + high) / 2;
        }

        return Math.min(nums[low], nums[high]);
//        return nums[high];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(LeetCodeQuickStart.quickStart(LeetCode153.class, (Object) new int[]{4,5,6,7,0,1,2}));
    }


    @Override
    public void run(Object object) {

    }

}
