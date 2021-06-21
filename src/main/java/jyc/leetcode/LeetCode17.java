package jyc.leetcode;

import jyc.annotation.QuickStart;
import jyc.aop.LeetCodeBase;
import jyc.utils.LeetCodeQuickStart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LeetCode17 implements LeetCodeBase {

    private List<String> res = new ArrayList<>();

    @QuickStart
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0){
            return res;
        }
        char[] charArray = digits.toCharArray();
        StringBuffer sb = new StringBuffer();
        backTracking(charArray, 0, sb);
        return res;
    }

    private void backTracking(char[] charArray, int begin, StringBuffer sb){
        if(begin == charArray.length - 1){
            for(char c : NumChars.getNum(charArray[begin] - '0')){
                res.add(sb.append(c).toString());
                sb.deleteCharAt(sb.length() - 1);
            }
            return;
        }
        for(int i = 0; i < NumChars.getNum(charArray[begin] - '0').length; i++){
            sb.append(NumChars.getNum(charArray[begin] - '0')[i]);
            backTracking(charArray, begin + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    enum NumChars{
        TWO(new char[]{'a','b','c'}),
        THREE(new char[]{'d','e','f'}),
        FOUR(new char[]{'g','h','i'}),
        FIVE(new char[]{'j','k','l'}),
        SIX(new char[]{'m','n','o'}),
        SEVEN(new char[]{'p','q','r','s'}),
        EIGHT(new char[]{'t','u','v'}),
        NINE(new char[]{'w','x','y','z'}),
        ;

        private char[] values;

        private char[] getValue(){
            return values;
        }

        NumChars(char[] chars) {
            this.values = chars;
        }

        public static char[] getNum(int num) {
            switch (num){
                case 2:
                    return NumChars.TWO.getValue();
                case 3:
                    return NumChars.THREE.getValue();
                case 4:
                    return NumChars.FOUR.getValue();
                case 5:
                    return NumChars.FIVE.getValue();
                case 6:
                    return NumChars.SIX.getValue();
                case 7:
                    return NumChars.SEVEN.getValue();
                case 8:
                    return NumChars.EIGHT.getValue();
                case 9:
                    return NumChars.NINE.getValue();
                default:
                    return NumChars.NINE.getValue();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(LeetCodeQuickStart.quickStart(LeetCode17.class, "234"));
    }


    @Override
    public void run(Object object) {

    }

}
