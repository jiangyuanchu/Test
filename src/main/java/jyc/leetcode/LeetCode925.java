package jyc.leetcode;

import jyc.aop.LeetCodeBase;
import jyc.utils.ListNode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode925 implements LeetCodeBase {

    public boolean isLongPressedName(String name, String typed) {
        int len_n = name.length();
        int len_t = typed.length();
        if(len_n>len_t){
            return false;
        }
        int i=0;
        int j=0;
        while(i<len_n&&j<len_t){
            if(name.charAt(i)==typed.charAt(j)){
                i++;
                j++;
            }else if(j>0&&typed.charAt(j)==typed.charAt(j-1)){
                j++;
            }else{
                return false;
            }
        }
        while(j<len_t){ //t 有剩余
            if(typed.charAt(j)!=typed.charAt(j-1))
                return false;
            j++;
        }
        return i ==len_n;
    }

    public static void main(String[] args) {
        LeetCode925 leetCode925 = new LeetCode925();
        System.out.println(leetCode925.isLongPressedName("leelee", "lleeelee"));
    }

    @Override
    public void run(Object object) {

    }

}
