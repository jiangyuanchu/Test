package jyc.leetcode;

import jyc.aop.LeetCodeBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 格雷码规则
 * n = n - 1 ---> 0 + (n-1)正序  <----->  1 + （n-1）倒序
 */
public class LeetCode89 implements LeetCodeBase {

    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        List<String> dealResult = new ArrayList<>();
        if(n == 0){
            result.add(0);
            return result;
        }
        dealResult.add("0");
        dealResult.add("1");
        for(int i = 1; i < n; i++){
            List<String> swap = new ArrayList<>();
            for(String a : dealResult){
                swap.add("0" + a);
            }
            for(int j = dealResult.size() - 1; j >= 0; j--){
                swap.add(new StringBuffer("1" + dealResult.get(j)).toString());
            }
            dealResult = swap;
        }

        for(String str : dealResult){
            result.add(Integer.parseInt(str, 2));
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode89 leetCode89 = new LeetCode89();
        System.out.println(leetCode89.grayCode(4));
    }

    @Override
    public void run(Object object) {

    }
}
