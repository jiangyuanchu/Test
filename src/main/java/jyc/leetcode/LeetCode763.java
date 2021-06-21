package jyc.leetcode;

import jyc.annotation.QuickStart;
import jyc.aop.LeetCodeBase;
import jyc.utils.LeetCodeQuickStart;
import jyc.utils.LeetCodeUtils;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class LeetCode763 extends LeetCodeUtils implements LeetCodeBase {

    @QuickStart
    public List<Integer> partitionLabels(String S) {
        List<Integer> resultList = new ArrayList<>();
        char[] charArray = S.toCharArray();
        int indexStart = 0;
        int indexEnd = 0;

        do{
            for(int i = indexStart; i < charArray.length; i++){
                if(charArray[indexStart] == charArray[i]){
                    indexEnd = i;
                }
            }
            for(int i = indexStart + 1; i < indexEnd; i++){
                for(int j = indexEnd + 1;j < charArray.length; j++){
                    if(charArray[j] == charArray[i]){
                        indexEnd = j;
                    }
                }
            }
            if(indexEnd - indexStart < 0){
                break;
            }
            resultList.add(indexEnd - indexStart + 1);
            indexStart = indexEnd + 1;

        }while(indexEnd < charArray.length);

        return resultList;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(LeetCodeQuickStart.quickStart(LeetCode763.class, "aba"));
    }

    @Override
    public void run(Object object) {
    }
}
