package jyc.leetcode;

import jyc.aop.LeetCodeBase;
import jyc.utils.LeetCodeUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode1452 implements LeetCodeBase {

    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> result = new ArrayList<>();
        if(favoriteCompanies.isEmpty()){
            return result;
        }
        //排序初始值
        HashMap<Integer, Map<List<String>, Integer>> lengthAndMap = new HashMap<>();
        Map<List<String>, Integer> initLocationMap = null;
        for(int i = 0; i < favoriteCompanies.size(); i++){
            if(lengthAndMap.containsKey(favoriteCompanies.get(i).size())){
                Map<List<String>, Integer> pd = lengthAndMap.get(favoriteCompanies.get(i).size());
                if(pd.containsKey(favoriteCompanies.get(i))){
                    pd.remove(favoriteCompanies.get(i));
                }else{
                    pd.put(favoriteCompanies.get(i), i);
                }
            }else{
                initLocationMap = new HashMap<>();
                initLocationMap.put(favoriteCompanies.get(i), i);
                lengthAndMap.put(favoriteCompanies.get(i).size(), initLocationMap);
            }
        }
        int max = 0;
        for(Integer size : lengthAndMap.keySet()){
            max = max > size ? max : size;
        }
        List<String> maxList = new ArrayList<>();
//        maxList.addAll(lengthAndMap.get(max).keySet().toArray());
        for(int i = max - 1; i > 0; i--){
            if(!lengthAndMap.containsKey(i)){
                continue;
            }


        }
        return null;
    }

    public static void main(String[] args) {
        LeetCode1452 leetCode1452 = new LeetCode1452();
    }



    @Override
    public void run(Object object) {

    }

}
