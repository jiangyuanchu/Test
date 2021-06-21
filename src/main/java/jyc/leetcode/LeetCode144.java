package jyc.leetcode;

import jyc.aop.LeetCodeBase;
import jyc.utils.LeetCodeUtils;
import jyc.utils.ListNode;
import jyc.utils.TreeNode;

import java.util.*;

public class LeetCode144 implements LeetCodeBase {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null){
            while (root != null) {
                result.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode144 leetCode144 = new LeetCode144();
        TreeNode treeNode = LeetCodeUtils.initTreeNode(new Integer[]{1,null,2 ,3});
        System.out.println(leetCode144.preorderTraversal(treeNode));
    }



    @Override
    public void run(Object object) {

    }

}
