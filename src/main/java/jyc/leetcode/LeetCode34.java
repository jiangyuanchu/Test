package jyc.leetcode;

import jyc.annotation.QuickStart;
import jyc.aop.LeetCodeBase;
import jyc.utils.LeetCodeQuickStart;

import java.util.HashMap;
import java.util.Set;

public class LeetCode34 implements LeetCodeBase {

    @QuickStart
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1};
        }
        int ts = 0;
        int te = nums.length;
        int index = -1;
        while(ts <= te){
            int middle = (ts + te) >>> 1;
            if(middle > nums.length - 1){
                break;
            }
            if(nums[middle] > target){
                te = middle - 1;
            } else if (nums[middle] < target){
                ts = middle + 1;
            } else {
                index = middle;
                break;
            }
        }
        int start = index;
        int end = index;
        while(true){
            boolean pd = true;
            if(start - 1 >= 0 && nums[start - 1] == target){
                start--;
                pd = false;
            }
            if(end + 1 < nums.length && nums[end + 1] == target){
                end++;
                pd = false;
            }
            if(pd){
                break;
            }
        }
        return new int[]{start, end};
    }

    public static void main(String[] args) throws Exception {
        int[] a = (int[])LeetCodeQuickStart.quickStart(LeetCode34.class, (Object) new int[]{2,2},3);
        for (int num : a) {
            System.out.println(num);
        }
    }

    @Override
    public void run(Object object) {

    }

}
