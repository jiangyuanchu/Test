package jyc.leetcode;

import jyc.aop.LeetCodeBase;

import java.util.Arrays;

public class LeetCode973 implements LeetCodeBase {

    public int[][] kClosest(int[][] points, int K) {
        int[] pointsSum = new int[points.length];
        int[] pointsSumCopy = new int[points.length];
        for(int i = 0; i < points.length; i++){
            int count = (int)(Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2));
            pointsSum[i] = count;
            pointsSumCopy[i] = count;
        }
        Arrays.sort(pointsSum);
        int[][] result = new int[K][2];
        for(int i = 0; i < K; i++){
            for(int j = 0; j < pointsSumCopy.length; j++){
                if(pointsSum[i] == pointsSumCopy[j]){
                    result[i][0] = points[j][0];
                    result[i][1] = points[j][1];
                    pointsSumCopy[j] = -1;
                    break;
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode973 leetCode973 = new LeetCode973();
        leetCode973.kClosest(new int[][]{{0,1},{1,0}}, 2);
    }

    @Override
    public void run(Object object) {

    }

}
