package jyc.leetcode;

import jyc.aop.LeetCodeBase;
import jyc.utils.ListNode;

import java.util.*;

public class LeetCode30 implements LeetCodeBase {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        HashMap<String, Integer> failedMap = new HashMap<>();
        HashMap<String, Integer> successMap = new HashMap<>();
        for(String str : words){
            hashMap.put(str, 0);
            failedMap.put(str, 0);
            if(successMap.containsKey(str)){
                successMap.put(str, successMap.get(str) + 1);
            }else{
                successMap.put(str, 1);
            }
        }
        int modelStart = 0;
        int modelEnd = words[0].length();
        while(modelEnd <= s.length()){
            String string = s.substring(modelStart, modelEnd);
            if(hashMap.containsKey(string)){
                hashMap.putAll(failedMap);
                int secondModelStart = modelStart;
                int secondModelEnd = modelEnd;
                while (secondModelEnd <= s.length()){
                    String aStr = s.substring(secondModelStart, secondModelEnd);
                    if(hashMap.containsKey(aStr)){
                        hashMap.put(aStr, hashMap.get(aStr) + 1);
                        if(hashMap.equals(successMap)){
                            result.add(modelStart);
                            hashMap.putAll(failedMap);
                            break;
                        }
                        if(hashMap.get(aStr) > successMap.get(aStr)){
                            break;
                        }
                    }else{
                        hashMap.putAll(failedMap);
                        break;
                    }
                    secondModelEnd += words[0].length();
                    secondModelStart += words[0].length();
                }
            }
            modelEnd++;
            modelStart++;
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode30 leetCode30 = new LeetCode30();
        String str = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};
        List<Integer> result = leetCode30.findSubstring(str, words);
        result.stream().forEach(System.out::println);
    }

    @Override
    public void run(Object object) {

    }

}
