package jyc.leetcode;

import jyc.annotation.QuickStart;
import jyc.aop.LeetCodeBase;
import jyc.utils.LeetCodeQuickStart;

import java.util.Arrays;

public class LeetCode190 implements LeetCodeBase {

    @QuickStart
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        String binaryInt = Integer.toBinaryString(n);
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < 32 - binaryInt.length(); i++){
            sb.append('0');
        }
        sb.append(binaryInt);
        sb.reverse();
        return Integer.parseInt(sb.toString(), 2);
    }

    //超出int最大值
    public static void main(String[] args) throws Exception {
//        System.out.println(LeetCodeQuickStart.quickStart(LeetCode190.class, 43261596));
        System.out.println(Integer.parseInt("11111111111111111111111111111101", 2));
    }



    @Override
    public void run(Object object) {

    }

}
