package jyc.leetcode.JianZhiOffer;

import jyc.annotation.QuickStart;
import jyc.aop.LeetCodeBase;
import jyc.utils.LeetCodeQuickStart;

import java.util.HashSet;
import java.util.Set;

public class JianZhiOffer03 implements LeetCodeBase {

    @QuickStart
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num)){
                return num;
            }else{
                set.add(num);
            }
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println((int)LeetCodeQuickStart.quickStart(JianZhiOffer03.class, new int[]{1, 2, 3, 3}));
    }

    @Override
    public void run(Object object) {

    }
}
