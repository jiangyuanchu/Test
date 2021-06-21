package jyc.leetcode;

import jyc.annotation.QuickStart;
import jyc.aop.LeetCodeBase;
import jyc.utils.LeetCodeQuickStart;

public class LeetCode363 implements LeetCodeBase {

    @QuickStart
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int[][][] stateCollect = new int[matrix.length][matrix.length][matrix[0].length];
        int max = Integer.MIN_VALUE;
        //初始化 长宽为1时的数据
        for(int j = 0; j < matrix.length; j++){
            for(int p = 0; p < matrix[0].length; p++){
                stateCollect[0][j][p] = matrix[j][p];
                if(matrix[j][p] <= k){
                    max = Math.max(max, matrix[j][p]);
                }
            }
        }
        //初始化 宽为1 长为n 时的数据
        for(int i = 1; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                for(int p = 0; p < matrix[0].length - i; p++){
                    stateCollect[i][j][p] = stateCollect[i - 1][j][p] + stateCollect[0][j][p + i];
                    if(stateCollect[i][j][p] <= k){
                        max = Math.max(max, stateCollect[i][j][p]);
                    }
                }
            }
        }
        //宽为 1~m 长度为 1~n 的数据
        for(int i = 1; i < matrix[0].length; i++){
            for(int y = 0; y < stateCollect.length; y++){
                for(int j = 0; j < matrix.length - i; j++){
                    for(int p = 0; p < matrix[0].length - y; p++){
                        for(int t = j; t < j + i; t++){
                            int sum = stateCollect[y][j][p] + stateCollect[y][j + i][p];
                            if(sum <= k){
                                max = Math.max(max, sum);
                            }
                        }
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(LeetCodeQuickStart.quickStart(LeetCode363.class, new int[][]{{1,-3,-1}}, 4));
    }


    @Override
    public void run(Object object) {

    }


//    public int maxSumSubmatrix(int[][] matrix, int k) {
//        int[][] sumArrays = matrix.clone();
//        int resultMin = k;
//        for(int i = 0; i < Math.min(matrix.length, matrix[0].length); i++){
//            for(int j = 0; j < matrix.length - i; j++){
//                for(int p = 0; p < matrix[0].length - i; p++){
//                    if(i != 0){
//                        int afterSum =  sumArrays[j - 1][p - 1];
//                        int nextSum = 0;
//                        for(int s = 0; s < i + 1; s++){
//                            nextSum += matrix[j + i][p + s];
//                            nextSum += matrix[j + s][p + i];
//                        }
//                        nextSum -= matrix[j + i][p + i];
//                        sumArrays[j][p] = nextSum;
//                    }
//                    if(sumArrays[j][p] < k){
//                        resultMin = Math.max(resultMin, sumArrays[j][p]);
//                    }
//                }
//            }
//
//        }
//    }
}
