package jyc.leetcode;

import jyc.annotation.QuickStart;
import jyc.aop.LeetCodeBase;
import jyc.utils.LeetCodeQuickStart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCodoMeeting0806Hanota implements LeetCodeBase {

    @QuickStart
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        hanota(A.size(),A,B,C);
    }

    /**
     * 汉诺塔问题
     * @param num 当前目标柱剩余数量
     * @param operation 当前操作柱
     * @param help 辅助柱
     * @param target 目标柱
     */
    private void hanota(int num, List<Integer> operation, List<Integer> help, List<Integer> target){
        if(num == 1){
            target.add(operation.remove(operation.size() - 1));
            return;
        }
        hanota(num - 1, operation, target, help);
        target.add(operation.remove(operation.size() - 1));
        hanota(num - 1, help, operation, target);
    }


    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>();
        for(int i = 4; i >=1 ; i--){
            list.add(i);
        }
        LeetCodeQuickStart.quickStart(LeetCodoMeeting0806Hanota.class, list, new ArrayList<Integer>(), new ArrayList<Integer>());
    }

    @Override
    public void run(Object object) {

    }
}
