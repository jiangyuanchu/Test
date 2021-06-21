package jyc.leetcode;

import jyc.annotation.QuickStart;
import jyc.aop.LeetCodeBase;
import jyc.utils.LeetCodeQuickStart;

import java.util.Arrays;

public class LeetCode852 implements LeetCodeBase {

    @QuickStart
    public int peakIndexInMountainArray(int[] arr) {
        return searchBinary(arr, 0, arr.length - 1, arr.length/2);
    }

    private int searchBinary (int[] arr, int begin, int end, int middle){
        if((middle - 1  < 0 && arr[middle] > arr[middle + 1]) || (middle + 1 > arr.length - 1 && arr[middle] > arr[middle - 1]) ||
                (arr[middle + 1] <  arr[middle] && arr[middle - 1] < arr[middle])){
            return middle;
        }
        if(middle - 1  < 0 && arr[middle] < arr[middle + 1]){
            return middle + 1;
        }
        if(arr[middle + 1] < arr[middle - 1]){
            return searchBinary(arr, begin, end = middle - 1, (begin + end)/2);
        }else{
            return searchBinary(arr, begin = middle + 1, end, (begin + end)/2);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(LeetCodeQuickStart.quickStart(LeetCode852.class, new int[]{0,1,2,0}));
//        System.out.println(System.currentTimeMillis());
    }


    @Override
    public void run(Object object) {

    }

}
