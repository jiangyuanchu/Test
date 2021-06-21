package jyc.leetcode;

import jyc.annotation.QuickStart;
import jyc.aop.LeetCodeBase;
import jyc.utils.LeetCodeQuickStart;

import java.util.Arrays;
import java.util.Stack;

/**
 * 经典回溯算法
 */
public class LeetCode52 implements LeetCodeBase {

    //场上棋子数
    private static int checkerCount = 11;
    private final int checkerCountSign = 11;

    @QuickStart
    public int totalNQueens(int n) {
        if(n == 0){
            return 0;
        }
        // 初始化棋盘
        // 棋盘格子状态 0可落子 1处于攻击范围 2格子废弃
        int[][] checkerBoard = new int[n][n];

        // 结果
        int resultCount = 0;

        // 回溯栈
        Stack<int[][]> stack = new Stack<>();
        stack.push(checkerBoard);

        // 落子
        do{
            if(chess(stack, stack.peek(), checkerCount - 11)){
                if(checkerCount == checkerCountSign + n - 1){
                    resultCount++;

//                    int[][] printResult = stack.peek();
//                    for(int i1 = 0;i1 < printResult.length;i1++){
//                        for(int j1 = 0;j1 < printResult[0].length;j1++){
//                            System.out.print(printResult[i1][j1] + "  ");
//                        }
//                        System.out.println("stack size = " + stack.size());
//                        System.out.println();
//                    }
//                    System.out.println("-----------------------------");
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }

                    holdChecker(stack);
                }
                checkerCount++;
            }else{
                if(stack.size() == 1){
                    int[][] endSign = stack.peek();
                    if(endSign[0][n - 1] == 2){
                        break;
                    }
                }
                holdChecker(stack);
            }
        }while (stack.size() >= 1);

        System.out.println(resultCount);
        return resultCount;
    }

    private boolean chess(Stack<int[][]> stack, int[][] checkerBoard, int chessCount){
            for(int j = 0; j < checkerBoard[0].length; j++){
                if(checkerBoard[chessCount][j] == 0){
                    int[][] newCheckerBoard = new int[checkerBoard.length][checkerBoard.length];
                    for(int i1 = 0;i1 < checkerBoard.length;i1++){
                        for(int j1 = 0;j1 < checkerBoard[chessCount].length;j1++){
                            newCheckerBoard[i1][j1] = checkerBoard[i1][j1];
                        }
                    }
                    influence(newCheckerBoard, chessCount, j);
                    stack.push(newCheckerBoard);
//                    for(int i1 = 0;i1 < checkerBoard.length;i1++){
//                        for(int j1 = 0;j1 < checkerBoard[chessCount].length;j1++){
//                            System.out.print(newCheckerBoard[i1][j1] + "  ");
//                        }
//                        System.out.println("stack size = " + stack.size());
//                        System.out.println();
//                    }
//                    System.out.println("-----------------------------");
//                    try {
//                        Thread.sleep(1500);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    return true;
                }
            }
        return false;
    }

    private void holdChecker(Stack<int[][]> stack){
        int[][] checkerBoard = stack.pop();
        int[][] fatherCheckerBoard = stack.pop();
        int maxCount = 10;
        int maxCountI = 0;
        int maxCountJ = 0;
        for (int i = 0; i < checkerBoard.length; i++){
            for(int j = 0; j < checkerBoard[0].length; j++){
                if(checkerBoard[i][j] > maxCount){
                    maxCount = checkerBoard[i][j];
                    maxCountI = i;
                    maxCountJ = j;
                }
            }
        }
        fatherCheckerBoard[maxCountI][maxCountJ] = 2;
        stack.push(fatherCheckerBoard);
        checkerCount--;
    }

    private void influence(int[][] checkerBoard,int i, int j){
        for(int k = 0; k < checkerBoard.length; k++){
            checkerBoard[i][k] = 1;
            checkerBoard[k][j] = 1;
            if(i + k < checkerBoard.length && j + k < checkerBoard.length){
                checkerBoard[i + k][j + k] = 1;
            }
            if(i - k >= 0 && j - k >= 0){
                checkerBoard[i - k][j - k] = 1;
            }
            if(i + k < checkerBoard.length && j - k >= 0){
                checkerBoard[i + k][j - k] = 1;
            }
            if(i - k >= 0 && j + k < checkerBoard.length){
                checkerBoard[i - k][j + k] = 1;
            }
        }
        checkerBoard[i][j] = checkerCount;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(LeetCodeQuickStart.quickStart(LeetCode52.class, 5));
    }

    @Override
    public void run(Object object) {
        totalNQueens(5);
    }
}
