package jyc.leetcode;

import jyc.annotation.MyAutowired;
import jyc.aop.LeetCodeBase;
import jyc.utils.LeetCodeUtils;
import lombok.Data;

import java.util.LinkedList;
import java.util.Queue;

@Data
public class LeetCode12 extends LeetCodeUtils implements LeetCodeBase {

    @MyAutowired
    private LeetCode15 leetCode15;


    public String intToRoman(int num) {
        //参数队列
        Queue<Character> numCharQueue = new LinkedList<>();
        //参数数组
        char[] numCharArray = String.valueOf(num).toCharArray();
        //队列赋值
        for(char c : numCharArray){
            numCharQueue.add(c);
        }
        //罗马字母基本字符定义
        char[] loma = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        //罗马字母数组索引
        int arrayLomaIndex = 0;
        if(numCharArray.length >= 3){
            arrayLomaIndex = loma.length - 1;
        }else{
            arrayLomaIndex = numCharArray.length * 2;
        }
        //参数数组索引
        int numCharArrayIndex = 0;
        //结果集
        StringBuffer lomanNum = new StringBuffer();
        //奇偶标志
        int ODD_EVEN_SIGN = 0;
        while(numCharQueue.size() >= 0){

            int count = 0;
            if(ODD_EVEN_SIGN % 2 == 0){
                count = num / (int)(Math.pow(10, numCharQueue.size()));
                num -= count*(int)(Math.pow(10, numCharQueue.size()));
                ODD_EVEN_SIGN++;
            }else if (numCharQueue.size() != 0){
                count = num / ((int)(Math.pow(10, numCharQueue.size())) / 2);
                num -= count*((int)(Math.pow(10, numCharQueue.size())) / 2);
                numCharQueue.poll();
                ODD_EVEN_SIGN++;
            }


            if(numCharArray[numCharArrayIndex] == '4' || numCharArray[numCharArrayIndex] == '9'){
                if(numCharArray[numCharArrayIndex] == '4'){
                    lomanNum.append(loma[arrayLomaIndex]);
                    lomanNum.append(loma[arrayLomaIndex + 1]);
                    arrayLomaIndex--;
                }else{
                    lomanNum.append(loma[arrayLomaIndex]);
                    lomanNum.append(loma[arrayLomaIndex + 2]);
                    arrayLomaIndex--;
                }

            }else{
                while (count != 0){
                    lomanNum.append(loma[arrayLomaIndex]);
                    count--;
                }
                arrayLomaIndex--;
            }
        }
        return lomanNum.toString();
    }

    @Override
    public void run(Object object) {
        System.out.println("leetcode15"+leetCode15);
        leetCode15.test();
    }
}
