package jyc.leetcode;

import jyc.annotation.QuickStart;
import jyc.aop.LeetCodeBase;
import jyc.utils.LeetCodeQuickStart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LeetCode842 implements LeetCodeBase {

    @QuickStart
    public List<Integer> splitIntoFibonacci(String S) {

        //回溯栈
        Stack<String> stack = new Stack<>();

        List<Integer> result = new ArrayList<>();

        for(int i = 1; i <= Math.floor(S.length()/2); i++){
            String split = S.substring(0,i);
            if(split.length() > 10){
                break;
            }
            if((split.length() > 1 && split.charAt(0) == '0')){
                return result;
            }
            stack.push(split);
            if(isSuccess(stack, S.substring(i))){
                break;
            }else{
                stack.pop();
            }
        }

        for(String s : stack){
            result.add(Integer.parseInt(s));
        }
        return result;
    }

    private boolean isSuccess(Stack<String> stack, String S){

        try {
            for(int i = 1; i <= Math.floor(S.length()/2); i++){
                Integer beforeCount = Integer.parseInt(stack.peek());
                Integer nowCount = Integer.parseInt(S.substring(0, i));
                Integer countAdd = beforeCount + nowCount;
                int countAddLength = countAdd == 0 ? 1 : (int) Math.floor(Math.log10(countAdd)) + 1;
                if(S.length() < countAddLength){
                    stack.pop();
                    return false;
                }else {
                    Integer trueSplitCount = S.length() <= i + countAddLength ? Integer.parseInt(S.substring(i)) : Integer.parseInt(S.substring(i, i + countAddLength));
                    if(countAdd.equals(trueSplitCount)){
                        stack.push(S.substring(0, i));
                        String split = S.substring(i);
                        if(countAddLength == split.length()){
                            stack.push(split);
                            return true;
                        }
                        if(isSuccess(stack, split)){
                            return true;
                        }else{
                            stack.pop();
                        }

                    }
                }
            }
        } catch (NumberFormatException e){
            return false;
        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(LeetCodeQuickStart.quickStart(LeetCode842.class, "214748364721474836422147483641").toString());
    }

    @Override
    public void run(Object object) {

    }

}
