package jyc.leetcode;

import jyc.annotation.QuickStart;
import jyc.aop.LeetCodeBase;
import jyc.utils.LeetCodeQuickStart;
import jyc.utils.LeetCodeUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Stack;

public class LeetCode406 implements LeetCodeBase {

    @QuickStart
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if(o1[1] == o2[1]){
                return o1[0] - o2[0];
            }else{
                return o1[1] - o2[1];
            }
        });
        LinkedList<int[]> linkedList = new LinkedList<>();
        for(int[] p : people){
            if(p[1] == 0){
                linkedList.add(p);
            }else{
                int max = p[0];
                int sum = p[1];
                int index = 0;
                boolean start = false;
                for(int i = 0; i < linkedList.size(); i++){
                    int[] item = linkedList.get(i);
                    if(item[0] >= max || start){
                        index++;
                        if(sum == index || start){
                            start = true;
                            if(i < linkedList.size() - 1 && linkedList.get(i + 1)[1] == sum){
                                continue;
                            }else {
                                linkedList.add(i + 1 ,p);
                            }
                            break;
                        }
                    }
                }
            }
        }

//        linkedList.stream().forEach(t -> {
//            Arrays.stream(t).forEach(System.out::print);
//            System.out.println();
//        });

        int[][] result = linkedList.toArray(people);

        return people;
    }

    public static void main(String[] args) throws Exception {
        int[][] a = (int[][]) LeetCodeQuickStart.quickStart(LeetCode406.class, (Object) new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}});
        for(int[] b : a){
            for(int c : b){
                System.out.print(c);
            }
            System.out.println();
        }
    }

    @Override
    public void run(Object object) {

    }

}
