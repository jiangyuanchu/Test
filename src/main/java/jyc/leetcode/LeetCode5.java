package jyc.leetcode;

import jyc.annotation.QuickStart;
import jyc.aop.LeetCodeBase;
import jyc.utils.LeetCodeQuickStart;

import java.util.Arrays;

public class LeetCode5 implements LeetCodeBase {

    @QuickStart
    public String longestPalindrome(String s) {
        int num = s.length();
        Boolean[][] sign = new Boolean[num][num];
        String result = "";
        for(int l = 0; l < num ; l++){
            for(int i = 0; i + l < num; i++){
                int j = i + l;
                if(l == 0){
                    sign[i][j] = true;
                }else if(l == 1){
                    sign[i][j] = (s.charAt(i) == s.charAt(j));
                }else{
                    sign[i][j] = (s.charAt(i) == s.charAt(j) && sign[i+1][j-1]);
                }
                if(sign[i][j] && j - i + 1 > result.length()){
                    result = s.substring(i, j + 1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(LeetCodeQuickStart.quickStart(LeetCode5.class, "babad"));
    }


    @Override
    public void run(Object object) {

    }

}
