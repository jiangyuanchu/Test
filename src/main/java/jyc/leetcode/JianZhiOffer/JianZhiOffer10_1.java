package jyc.leetcode.JianZhiOffer;

import jyc.aop.LeetCodeBase;

public class JianZhiOffer10_1 implements LeetCodeBase {

    public int fib(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1 || n == 2){
            return 1;
        }
        int[] array = new int[n];
        int result = 0;
        array[0] = 1;
        array[1] = 1;
        for(int i = 2; i < n; i++){
            array[i] = (array[i - 2] + array[i - 1]) % 1000000007;
        }
        return array[n - 1];
    }

    public static void main(String[] args) {
        JianZhiOffer10_1 jianZhiOffer10_1 = new JianZhiOffer10_1();
        System.out.println(jianZhiOffer10_1.fib(46));
    }

    @Override
    public void run(Object object) {

    }
}
