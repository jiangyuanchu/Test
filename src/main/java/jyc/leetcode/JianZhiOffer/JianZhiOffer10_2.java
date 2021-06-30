package jyc.leetcode.JianZhiOffer;

import jyc.annotation.QuickStart;
import jyc.aop.LeetCodeBase;
import jyc.utils.LeetCodeQuickStart;

import java.util.HashSet;
import java.util.Set;

public class JianZhiOffer10_2 implements LeetCodeBase {

    @QuickStart
    public int numWays(int n) {
        if(n == 0 || n == 1){
            return 1;
        }
        long temp1 = 1;
        long temp2 = 2;
        for(int i = 2; i < n; i++){
            long sum = (temp1 + temp2) % 1000000007;
            temp1 = temp2;
            temp2 = sum;
        }
        return (int) temp1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println((int)LeetCodeQuickStart.quickStart(JianZhiOffer10_2.class, 44));
    }

    @Override
    public void run(Object object) {

    }
}

//
//if(n == 0 || n == 1){
//        return 1;
//        }
//        int[] array = new int[n];
//        array[0] = 1;
//        array[1] = 2;
//        for(int i = 2; i < n; i++){
//        array[i] = (array[i - 1] % 1000000007) + (array[i - 2] % 1000000007);
//        }
//        return array[n - 1] % 1000000007;