package jyc.leetcode;

import jyc.aop.LeetCodeBase;
import jyc.utils.LeetCodeUtils;
import jyc.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode199 implements LeetCodeBase {


    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> firstQueue = new LinkedList<>();
        Queue<TreeNode> secondQueue = new LinkedList<>();
        firstQueue.add(root);
        while(!(firstQueue.isEmpty() && secondQueue.isEmpty())){
            boolean increase = true;
            while(!firstQueue.isEmpty()){
                TreeNode treeNode = firstQueue.poll();
                if(increase){
                    result.add(treeNode.val);
                    increase = false;
                }
                if(treeNode.right != null){
                    secondQueue.add(treeNode.right);
                }
                if(treeNode.left != null){
                    secondQueue.add(treeNode.left);
                }
            }
            increase = true;
            while(!secondQueue.isEmpty()){
                TreeNode treeNode = secondQueue.poll();
                if(increase){
                    result.add(treeNode.val);
                    increase = false;
                }
                if(treeNode.right != null){
                    firstQueue.add(treeNode.right);
                }
                if(treeNode.left != null){
                    firstQueue.add(treeNode.left);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode199 leetCode199 = new LeetCode199();
        TreeNode root = LeetCodeUtils.initTreeNode(new Integer[]{1,2,3,null,5,null,4,null,null,null,6});
        LeetCodeUtils.printTreeNode(root);
        System.out.println(leetCode199.rightSideView(root));
    }



    @Override
    public void run(Object object) {

    }

}
