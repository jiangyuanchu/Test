package jyc.leetcode;

import jyc.aop.LeetCodeBase;

import java.util.HashMap;

public class LeetCode463 implements LeetCodeBase {

    public int islandPerimeter(int[][] grid) {
        HashMap<Integer, Boolean> firstRow = new HashMap<>();
        int sum = 0;
        for(int[] arrays : grid){
            HashMap<Integer, Boolean> secondRow = new HashMap<>();
            for(int i = 0; i < arrays.length; i++){
                if(arrays[i] == 1){
                    sum += 4;
                    if(i - 1 >= 0 && arrays[i - 1] == 1){
                        sum -= 2;
                    }
                    if(firstRow.containsKey(i) && firstRow.get(i)){
                        sum -= 2;
                    }
                    secondRow.put(i, true);
                }
            }
            firstRow = (HashMap<Integer, Boolean>) secondRow.clone();
        }
        return sum;
    }

    public static void main(String[] args) {
        LeetCode463 leetCode463 = new LeetCode463();
        System.out.println(leetCode463.islandPerimeter(new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}}));
    }


    @Override
    public void run(Object object) {

    }

}
