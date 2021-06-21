package jyc.leetcode;

import jyc.aop.LeetCodeBase;

public class LeetCode941 implements LeetCodeBase {

    public boolean validMountainArray(int[] A) {
        boolean topSign = false;
        boolean aroundLeft = false;
        boolean aroundRight = false;
        for(int i = 0;i < A.length - 1; i++){
            if(!topSign){
                if(A[i] >= A[i + 1]){
                    topSign = true;
                    i--;
                    continue;
                }
                aroundLeft = true;
            }else{
                if(A[i] <= A[i + 1])
                    return false;
                aroundRight = true;
            }
        }
        return aroundLeft && aroundRight;
    }

    @Override
    public void run(Object object) {

    }

}
