package jyc.leetcode;

import jyc.annotation.QuickStart;
import jyc.aop.LeetCodeBase;
import jyc.utils.LeetCodeQuickStart;

import java.util.Arrays;

public class LeetCode50 implements LeetCodeBase {

    @QuickStart
    public double myPow(double x, int n) {
        return  Math.pow(x, n);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(LeetCodeQuickStart.quickStart(LeetCode50.class, 0.000001, 20));
    }


    @Override
    public void run(Object object) {

    }

}
