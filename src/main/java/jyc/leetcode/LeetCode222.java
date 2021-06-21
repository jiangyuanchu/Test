package jyc.leetcode;

import jyc.annotation.QuickStart;
import jyc.aop.LeetCodeBase;
import jyc.utils.LeetCodeQuickStart;
import jyc.utils.LeetCodeUtils;
import jyc.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LeetCode222 implements LeetCodeBase {

    @QuickStart
    public int countNodes(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int treeDepth = 0;
        TreeNode rootCopyForDepth = root;
        while(rootCopyForDepth != null){
            rootCopyForDepth = rootCopyForDepth.left;
            treeDepth++;
        }
        queue.add(root);
        for(int i = 0; i < treeDepth; i++){
            if(queue.size() == Math.pow(2,i) && i == treeDepth - 1){
                return (int) (Math.pow(2,treeDepth) - 1);
            }else if(queue.size() != Math.pow(2,i)){
                return (int) (Math.pow(2,treeDepth - 1) - 1) + queue.size();
            }
            for(int j = 0; j < Math.pow(2,i); j++){
                TreeNode stackFirstNode = queue.poll();
                if(stackFirstNode.left != null)
                    queue.add(stackFirstNode.left);
                if(stackFirstNode.right != null)
                    queue.add(stackFirstNode.right);
            }

        }

        return 0;
    }

    public static void main(String[] args) throws Exception{
        System.out.println((int)LeetCodeQuickStart.quickStart(LeetCode222.class, LeetCodeUtils.initTreeNode(new Integer[]{1,2,3,4,5,6})));
    }

    @Override
    public void run(Object object) {

    }

}
