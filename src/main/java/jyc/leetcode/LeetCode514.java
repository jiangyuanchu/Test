package jyc.leetcode;

import jyc.aop.LeetCodeBase;

import java.util.HashMap;

public class LeetCode514 implements LeetCodeBase {

    public int findRotateSteps(String ring, String key) {
        return 0;
    }

    public static void main(String[] args) {
        LeetCode514 leetCode514 = new LeetCode514();
        System.out.println(leetCode514.findRotateSteps("godding", "godding"));
    }

    @Override
    public void run(Object object) {

    }

    //理解错误，不像电话盘一样会自动复位
    public int failedFindRotateSteps(String ring, String key) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0, j = ring.length() - 1; i <= j; i++, j--){
            if(i == j){
                stringBuffer.append(ring.charAt(i));
                break;
            }
            stringBuffer.append(ring.charAt(i));
            stringBuffer.insert(0, ring.charAt(j));
        }
        char[] ringArray = stringBuffer.toString().toCharArray();
        int count = 0;
        for(char k : key.toCharArray()){
            for(int i = ringArray.length/2, j = i, m = 0; i >= 0 && j < ringArray.length + 1; i--, j++, m++){
                if(j >= ringArray.length){
                    if(k == ringArray[i]){
                        count += m + 1;
                        break;
                    }
                }else{
                    if(k == ringArray[i] || k == ringArray[j]){
                        count += m + 1;
                        break;
                    }
                }
            }
        }
        return count;
    }
}
