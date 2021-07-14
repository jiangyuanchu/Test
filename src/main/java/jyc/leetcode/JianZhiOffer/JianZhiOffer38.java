package jyc.leetcode.JianZhiOffer;

import jyc.annotation.QuickStart;
import jyc.aop.LeetCodeBase;
import jyc.utils.LeetCodeQuickStart;
import jyc.utils.LeetCodeUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 字符串排列
 * 回溯算法
 */
public class JianZhiOffer38 implements LeetCodeBase {

    private List<String> resultList = new ArrayList<>();
    private StringBuilder oneResult = new StringBuilder();

    @QuickStart
    public String[] permutation(String s) {
        backtracking(new StringBuilder(s));
        return resultList.stream().distinct().toArray(String[]::new);
    }

    private void backtracking(StringBuilder stringBuilder){
        if(stringBuilder.length() == 1){
            oneResult.append(stringBuilder.charAt(0));
            resultList.add(oneResult.toString());
            oneResult.deleteCharAt(oneResult.length() - 1);
            return;
        }
        for(int i = 0; i < stringBuilder.length(); i++){
            oneResult.append(stringBuilder.charAt(i));
            backtracking(new StringBuilder(stringBuilder).deleteCharAt(i));
            oneResult.deleteCharAt(oneResult.length() - 1);
        }

    }

    public static void main(String[] args) throws Exception {
        LeetCodeUtils.printArray((String[])LeetCodeQuickStart.quickStart(JianZhiOffer38.class, "aab"));
    }

    @Override
    public void run(Object object) {

    }
}
