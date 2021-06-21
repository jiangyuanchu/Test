package jyc.leetcode;

import jyc.annotation.QuickStart;
import jyc.aop.LeetCodeBase;
import jyc.utils.LeetCodeQuickStart;

import java.util.Arrays;
import java.util.Stack;

public class LeetCode922 implements LeetCodeBase {

    @QuickStart
    public int[] sortArrayByParityII(int[] A) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i <  A.length; i++){
            if((i + A[i]) % 2 != 0){
                if(stack.isEmpty()){
                    stack.add(i);
                }else if((stack.peek() + i) % 2 != 0){
                    int swap = A[stack.peek()];
                    A[stack.pop()] = A[i];
                    A[i] = swap;
                }else{
                    stack.add(i);
                }
            }
        }
        return A;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.toString((int[]) LeetCodeQuickStart.quickStart(LeetCode922.class, new int[]{4, 2, 5, 7})));
    }

    @Override
    public void run(Object object) {

    }

}
