package jyc.leetcode;

import jyc.annotation.QuickStart;
import jyc.aop.LeetCodeBase;
import jyc.utils.LeetCodeQuickStart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LeetCode40 implements LeetCodeBase {

    private List<List<Integer>> res = new ArrayList<>();

    @QuickStart
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        backTracking(path, candidates, target, 0, 0);
        return res.stream().distinct().collect(Collectors.toList());
    }

    private void backTracking(List<Integer> path, int[] candidates,int target, int sum, int begin){
        if(sum == target){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = begin; i < candidates.length; i++){
            int rs = sum + candidates[i];
            if(rs <= target){
                path.add(candidates[i]);
                backTracking(path, candidates, target, rs, i + 1);
                path.remove(path.size() - 1);
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(LeetCodeQuickStart.quickStart(LeetCode40.class, new int[]{10,1,2,7,6,1,5}, 8));
    }


    @Override
    public void run(Object object) {

    }

}
