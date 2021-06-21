package jyc.leetcode;

import jyc.annotation.QuickStart;
import jyc.aop.LeetCodeBase;
import jyc.utils.LeetCodeQuickStart;
import jyc.utils.LeetCodeUtils;

import java.util.*;

public class LeetCode452 implements LeetCodeBase {

    @QuickStart
    public int findMinArrowShots(int[][] points) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        for(int i = 0; i < points.length; i++){
            boolean pd = true;
            for(int[] ballBoundary : result){
                if(ballBoundary[0] <= points[i][0] && ballBoundary[1] >= points[i][1]){
                    pd = false;
                    ballBoundary[0] = points[i][0];
                    ballBoundary[1] = points[i][1];
                    break;
                }else if(ballBoundary[0] <= points[i][0] && ballBoundary[1] <= points[i][1] && ballBoundary[1] >= points[i][0]){
                    pd = false;
                    ballBoundary[0] = points[i][0];
                    break;
                }else if(ballBoundary[0] >= points[i][0] && ballBoundary[1] >= points[i][1] && ballBoundary[0] <= points[i][1]){
                    pd = false;
                    ballBoundary[1] = points[i][1];
                    break;
                }else if(ballBoundary[0] >= points[i][0] && ballBoundary[1] <= points[i][1]){
                    pd = false;
                    break;
                }
            }
            if(pd){
                result.add(new int[]{points[i][0], points[i][1]});
            }
        }
        return result.size();
    }


//    public int findMinArrowShots(int[][] points) {
//        List<BallBoundary> result = new ArrayList<>();
//        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
//        for(int[] array : points){
//            System.out.println(array[0] + "---" + array[1]);
//        }
//        for(int i = 0; i < points.length; i++){
//            boolean pd = true;
//            for(BallBoundary ballBoundary : result){
//                if(ballBoundary.min <= points[i][0] && ballBoundary.max >= points[i][1]){
//                    pd = false;
//                    ballBoundary.setMin(points[i][0]);
//                    ballBoundary.setMax(points[i][1]);
//                    break;
//                }else if(ballBoundary.min <= points[i][0] && ballBoundary.max <= points[i][1] && ballBoundary.max >= points[i][0]){
//                    pd = false;
//                    ballBoundary.setMin(points[i][0]);
//                    break;
//                }else if(ballBoundary.min >= points[i][0] && ballBoundary.max >= points[i][1] && ballBoundary.min <= points[i][1]){
//                    pd = false;
//                    ballBoundary.setMax(points[i][1]);
//                    break;
//                }else if(ballBoundary.min >= points[i][0] && ballBoundary.max <= points[i][1]){
//                    pd = false;
//                    break;
//                }
//            }
//            if(pd){
//                result.add(new BallBoundary(points[i][0], points[i][1]));
//            }
//        }
//        return result.size();
//    }
//
//    class BallBoundary{
//        int min;
//        int max;
//
//        public int getMin() {
//            return min;
//        }
//
//        public void setMin(int min) {
//            this.min = min;
//        }
//
//        public int getMax() {
//            return max;
//        }
//
//        public void setMax(int max) {
//            this.max = max;
//        }
//
//        public BallBoundary(int min, int max) {
//            this.min = min;
//            this.max = max;
//        }
//    }

    public static void main(String[] args) throws Exception {
//        LeetCodeUtils.arrayFormatConversion(" [[3,9],[7,12],[3,8],[6,8],[9,10],[2,9],[0,9],[3,9],[0,6],[2,8]]");
        System.out.println((int) LeetCodeQuickStart.quickStart(LeetCode452.class, (Object) new int[][]{{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}}));
    }

    @Override
    public void run(Object object) {

    }

}
