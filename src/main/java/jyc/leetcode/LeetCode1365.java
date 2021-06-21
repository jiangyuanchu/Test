package jyc.leetcode;

import jyc.aop.LeetCodeBase;

import java.util.Arrays;
import java.util.HashMap;

public class LeetCode1365 implements LeetCodeBase {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] numsCopy = nums.clone();
        int[] result = new int[nums.length];
        Arrays.sort(numsCopy);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!hashMap.containsKey(numsCopy[i])){
                hashMap.put(numsCopy[i], i);
            }
        }
        for(int i = 0; i < nums.length; i++){
            result[i] = hashMap.get(nums[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode1365 leetCode300 = new LeetCode1365();
        System.out.println(leetCode300.smallerNumbersThanCurrent(new int[]{8,1,2,2,3}));
    }


    @Override
    public void run(Object object) {

    }

}
