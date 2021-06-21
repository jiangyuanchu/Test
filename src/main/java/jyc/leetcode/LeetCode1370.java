package jyc.leetcode;

import jyc.annotation.QuickStart;
import jyc.aop.LeetCodeBase;
import jyc.utils.LeetCodeQuickStart;

import java.util.*;

public class LeetCode1370 implements LeetCodeBase {

    @QuickStart
    public String sortString(String s) {
        Map<Character, Integer> map = new TreeMap<>();
        for(char r : s.toCharArray()){
            if(map.containsKey(r)){
                map.put(r, map.get(r) + 1);
            }else{
                map.put(r, 1);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while(map.size() != 0){
            StringBuilder stringBuilder1 = new StringBuilder();
            Iterator<Character> iterator = map.keySet().iterator();
            while(iterator.hasNext()){
                char c = iterator.next();
                stringBuilder.append(c);
                if(map.get(c) == 1){
                    iterator.remove();
                }else{
                    map.put(c, map.get(c) - 1);
                }
            }
            iterator = map.keySet().iterator();
            while(iterator.hasNext()){
                char c = iterator.next();
                stringBuilder1.append(c);
                if(map.get(c) == 1){
                    iterator.remove();
                }else{
                    map.put(c, map.get(c) - 1);
                }
            }
            stringBuilder.append(stringBuilder1.reverse());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws Exception{
        System.out.println(LeetCodeQuickStart.quickStart(LeetCode1370.class, "aaaabbbbccc"));
    }

    @Override
    public void run(Object object) {

    }

}
