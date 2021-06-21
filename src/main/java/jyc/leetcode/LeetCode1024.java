package jyc.leetcode;

import jyc.aop.LeetCodeBase;
import jyc.utils.LeetCodeUtils;
import jyc.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode1024 implements LeetCodeBase {

    public int videoStitching(int[][] clips, int T) {
        int result = 0;
        int last = -0;
        int j = 0;
        while (last < T){
            int num = 0;
            boolean pd = false;
            for(int i = 0; i < clips.length; i++){
                if(clips[i][0] <= last && clips[i][1] > last){
                    num = clips[i][1] - last > num ? clips[i][1] - last : num;
                    pd = true;
                }
            }
            if(!pd){
                return -1;
            }
            last += num;
            result++;
            j++;
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode1024 leetCode1024 = new LeetCode1024();
        System.out.println(leetCode1024.videoStitching(new int[][]{{0,5},{6,8}}, 7));
//        {0,2},{4,6},{8,10},{1,9},{1,5},{5,9}
    }



    @Override
    public void run(Object object) {

    }

}
