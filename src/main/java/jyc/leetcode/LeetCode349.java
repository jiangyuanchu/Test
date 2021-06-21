package jyc.leetcode;

import jyc.aop.LeetCodeBase;

import java.util.*;

public class LeetCode349 implements LeetCodeBase {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> hashSet1 = new HashSet<>();
        Set<Integer> arrayList = new HashSet<>();
        Arrays.sort(nums1);
        for(int num : nums1){
            hashSet1.add(num);
        }
        for(int num : nums2){
            if(hashSet1.contains(num)){
                arrayList.add(num);
            }
        }

        int[] result = new int[arrayList.size()];
        int start = 0;
        for (int item : arrayList) {
            result[start] = item;
            start++;
        }
        return result;

    }

    @Override
    public void run(Object object) {

    }

}
