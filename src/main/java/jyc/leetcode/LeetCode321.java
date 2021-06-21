package jyc.leetcode;

import jyc.annotation.QuickStart;
import jyc.aop.LeetCodeBase;
import jyc.utils.LeetCodeQuickStart;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 未解决
 */
public class LeetCode321 implements LeetCodeBase {

    private List<Integer> result = new ArrayList<>();

    @QuickStart
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {

        return recursive(nums1, nums2, k).stream().mapToInt(t -> t).toArray();

    }

    private List<Integer> recursive(int[] nums1, int[] nums2, int k){
        List<Integer> result = new ArrayList<>();
        int[] numArray = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, numArray, 0, nums1.length);
        System.arraycopy(nums2, 0, numArray, nums1.length, nums2.length);
        Arrays.sort(numArray);
        List<Integer> list = Arrays.stream(numArray).boxed().collect(Collectors.toList());
        Collections.reverse(list);
        numArray = list.stream().mapToInt(t -> t).toArray();

//        for (int i : numArray) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
        if(k == 1){
            //如果仅剩一个值， 返回剩余队列中最大值
            result.add(numArray[0]);
            System.out.println("递归唯一值"+result);
            return result;
        }
        //本次递归目标值
        for(int num : numArray) {
            //判断搜索哪个队列
            int num1Exits = -1;
            int num2Exits = -1;
            int targetArray = -1;
            for (int i = 0; i < nums1.length; i++) {
                if (num == nums1[i]) {
                    num1Exits = i;
                    break;
                }
            }
            if (num1Exits >= 0) {
                for (int i = 0; i < nums2.length; i++) {
                    if (num == nums2[i]) {
                        num2Exits = i;
                        break;
                    }
                }
            }
            if (num1Exits > 0 && num2Exits >= 0) {
                if (num2Exits == 0) {
                    targetArray = 1;
                } else {
                    int[] nums1SplitForTagert = new int[num1Exits];
                    System.arraycopy(nums1, 0, nums1SplitForTagert, 0, num1Exits);
                    Arrays.sort(nums1SplitForTagert);
                    List<Integer> mio = Arrays.stream(nums1SplitForTagert).boxed().collect(Collectors.toList());
                    Collections.reverse(mio);
                    nums1SplitForTagert = mio.stream().mapToInt(t -> t).toArray();

                    int[] nums2SplitForTagert = new int[num2Exits];
                    System.arraycopy(nums2, 0, nums2SplitForTagert, 0, num2Exits);
                    Arrays.sort(nums2SplitForTagert);
                    List<Integer> mio2 = Arrays.stream(nums2SplitForTagert).boxed().collect(Collectors.toList());
                    Collections.reverse(mio2);
                    nums2SplitForTagert = mio2.stream().mapToInt(t -> t).toArray();

                    int size = nums1SplitForTagert.length > nums2SplitForTagert.length ? nums2SplitForTagert.length : nums1SplitForTagert.length;
                    for (int i = 0; i < size; i++) {
                        if (nums1SplitForTagert[i] > nums2SplitForTagert[i]) {
                            targetArray = 2;
                            break;
                        } else if (nums1SplitForTagert[i] < nums2SplitForTagert[i]) {
                            targetArray = 1;
                            break;
                        }
                    }
                    if (targetArray == -1) {
                        targetArray = nums1SplitForTagert.length > nums2SplitForTagert.length ? 2 : 1;
                    }
                }
            }else if(num1Exits == 0 && num2Exits == 0){
                for(int i = 1;;i++){
                    if(nums1.length > i && nums2.length > i){
                        if(nums1[i] == nums2[i]){
                            continue;
                        }
                        targetArray = nums1[i] > nums2[i] ? 1 : 2;
                        break;
                    }else{
                        targetArray = nums1.length > nums2.length ? 1 : 2;
                        break;
                    }
                }

            }

            //        for(int num : numArray){
            boolean pd = false;
            switch (targetArray) {
                default:
                case 1:
                    for (int i = 0; i < nums1.length; i++) {
                        if (nums1[i] == num) {
                            if (nums1.length - i + nums2.length < k) {
                                break;
                            }
                            int[] nums1Split = new int[nums1.length - 1 - i];
                            System.arraycopy(nums1, i + 1, nums1Split, 0, nums1.length - 1 - i);
                            System.out.println("111数组递归入参：nums1Split="+ Arrays.toString(nums1Split) +" nums2="+ Arrays.toString(nums2) + " k="+(k - 1));
                            List<Integer> list1 = recursive(nums1Split, nums2, --k);
                            if (list1.size() == 0) {
                                break;
                            } else {
                                result.add(num);
                                result.addAll(list1);
                            }
                            pd = true;
                            break;
                        }
                    }
                case 2:
                    if (!pd) {
                        for (int i = 0; i < nums2.length; i++) {
                            if (nums2[i] == num) {
                                if (nums2.length - i + nums1.length < k) {
                                    break;
                                }
                                int[] nums1Split = new int[nums2.length - 1 - i];
                                System.arraycopy(nums2, i + 1, nums1Split, 0, nums2.length - 1 - i);
                                System.out.println("222数组递归入参：nums1="+ Arrays.toString(nums1) +" nums1Split="+ Arrays.toString(nums1Split) + " k="+(k - 1));
                                List<Integer> list1 = recursive(nums1, nums1Split, --k);
                                if (list1.size() == 0) {
                                    break;
                                } else {
                                    result.add(num);
                                    result.addAll(list1);
                                }
                                pd = true;
                                break;
                            }
                        }
                    }
            }
            if(pd){
                break;
            }
        }
        System.out.println("递归结束 返回值" + Arrays.toString(result.toArray()));
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.toString((int[]) LeetCodeQuickStart.quickStart(LeetCode321.class, new int[]{1,5,8,1,4,0,8,5,0,7,0,5,7,6,0,5,5,2,4,3,6,4,6,6,3,8,1,1,3,1,3,5,4,3,9,5,0,3,8,1,4,9,8,8,3,4,6,2,5,4,1,1,4,6,5,2,3,6,3,5,4,3,0,7,2,5,1,5,3,3,8,2,2,7,6,7,5,9,1,2},
                new int[]{7,8,5,8,0,1,1,6,1,7,6,9,6,6,0,8,5,8,6,3,4,0,4,6,7,8,7,7,7,5,7,2,5,2,1,9,5,9,3,7,3,9,9,3,1,4,3,3,9,7,1,4,4,1,4,0,2,3,1,3,2,0,2,4,0,9,2,0,1,3,9,1,2,2,6,6,9,3,6,0}, 80)));
    }

    @Override
    public void run(Object object) {

    }
}
