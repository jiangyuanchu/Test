package jyc.leetcode;

import jyc.annotation.QuickStart;
import jyc.aop.LeetCodeBase;
import jyc.utils.LeetCodeQuickStart;
import jyc.utils.LeetCodeUtils;
import jyc.utils.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LeetCode767 implements LeetCodeBase {

    @QuickStart
    public String reorganizeString(String S) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char s :  S.toCharArray()){
            if(hashMap.containsKey(s)){
                hashMap.put(s, hashMap.get(s) + 1);
            }else{
                hashMap.put(s, 1);
            }
        }
        Set<Character> set =  hashMap.keySet();
        for(int i = 0; i < set.size(); i++){

        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(LeetCodeQuickStart.quickStart(LeetCode767.class, ""));
    }

    @Override
    public void run(Object object) {

    }

}
