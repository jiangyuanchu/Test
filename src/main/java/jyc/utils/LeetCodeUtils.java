package jyc.utils;

import java.util.*;

public class LeetCodeUtils {

    /**
     * 二叉树初始化
     * @param intArray
     * @return
     */
    public static TreeNode initTreeNode(Integer[] intArray){
        if(intArray.length == 0) {
            return null;
        }
        if(intArray.length == 1) {
            return new TreeNode(intArray[0]);
        }
        TreeNode root = new TreeNode(intArray[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for(int i = 1; i < intArray.length; i++){
            TreeNode treeNode = queue.poll();
            if(i % 2 == 1 && intArray[i] != null){
                treeNode.left = new TreeNode(intArray[i]);
                queue.add(treeNode.left);
            }
            i++;
            if(i < intArray.length && i % 2 == 0 && intArray[i] != null){
                treeNode.right = new TreeNode(intArray[i]);
                queue.add(treeNode.right);
            }

        }
        return root;
    }

    /**
     * 打印标准二叉树 (广度遍历，List形式)
     * @param root
     */
    public static void printTreeNode(TreeNode root){
        List<Integer> treeNodeList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        treeNodeList.add(root.val);
        while(!queue.isEmpty()){
            TreeNode treeNode = queue.poll();
            if(treeNode.left != null){
                treeNodeList.add(treeNode.left.val);
                queue.add(treeNode.left);
            }else{
                treeNodeList.add(null);
            }
            if(treeNode.right != null){
                treeNodeList.add(treeNode.right.val);
                queue.add(treeNode.right);
            }else{
                treeNodeList.add(null);
            }
        }
        System.out.println(treeNodeList.toString());
    }

    /**
     * 单向链表初始化
     * @return
     */
    public static ListNode initOneWayListNodeInit(Integer[] intArray){
        if(intArray.length == 0) {
            return null;
        }
        if(intArray.length == 1) {
            return new ListNode(intArray[0]);
        }
        ListNode root = new ListNode(intArray[0]);
        ListNode point = root;
        for(int i = 1; i < intArray.length; i++){
            point.next = new ListNode(intArray[i]);
            point = point.next;
        }
        return root;
    }

    /**
     * 打印单向链表
     * @param root
     */
    public static void printListNode(ListNode root){
        while(root != null){
            if(root.next != null){
                System.out.print(root.val + " -> ");
                root = root.next;
            }else{
                System.out.println(root.val);
                root = root.next;
            }
        }
    }

    /**
     * 打印数组
     * @param objArray
     */
    public static void printArray(Object[] objArray){
        if(objArray == null){
            System.out.println("null");
            return;
        }
        if(objArray.length == 0){
            System.out.println("[]");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Arrays.stream(objArray).forEach(t -> sb.append(t.toString()).append(", "));
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        System.out.println(sb.toString());
    }

    /**
     * LeetCode输入数组 字符串转换工具
     * @param str
     */
    public static void arrayFormatConversion(String str){
        str = str.replace('[','{');
        str = str.replace(']','}');
        System.out.println("LeetCode输入数组 字符串转换:");
        System.out.println(str);

    }

    /**
     * 字符串数学表达式求值
     * @param str
     * @return
     * @throws Exception
     */
    //todo
    private int stingMathExpressionCalculate(String str) throws Exception{
        char[] array = str.toCharArray();
        int count = 0;
        Stack<Character> bracketStack = new Stack<>();
        Stack<Character> addAndSubtractStack = new Stack<>();
        for(char c : array){
            if(c == '('){
                bracketStack.add(c);
            }
        }
        return count;
    }

}
