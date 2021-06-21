package jyc.leetcode;

import jyc.aop.LeetCodeBase;
import jyc.utils.LeetCodeUtils;
import jyc.utils.TreeNode;
import org.apache.log4j.helpers.QuietWriter;

import java.util.*;

public class LeetCode129 implements LeetCodeBase {


    public int sumNumbers(TreeNode root) {
        int sum = 0;
        if(root == null){
            return sum;
        }
        HashMap<TreeNode, Integer> resultMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        resultMap.put(root, root.val);
        while(!queue.isEmpty()){
            TreeNode treeNode = ((LinkedList<TreeNode>) queue).pop();
            if(treeNode == null){
                continue;
            }
            if(treeNode.left != null){
                queue.add(treeNode.left);
                resultMap.put(treeNode.left, resultMap.get(treeNode) * 10 + treeNode.left.val);
            }
            if(treeNode.right != null){
                queue.add(treeNode.right);
                resultMap.put(treeNode.right, resultMap.get(treeNode) * 10 + treeNode.right.val);
            }
            if(treeNode.right == null && treeNode.left == null){
                sum += resultMap.get(treeNode);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode treeNode = LeetCodeUtils.initTreeNode(new Integer[]{4,9,0,5,1});
        LeetCode129 leetCode129 = new LeetCode129();
        Long startTime = System.nanoTime();
        System.out.println(leetCode129.sumNumbers(treeNode));
        Long endTime = System.nanoTime();
        System.out.println(endTime - startTime);
    }

    @Override
    public void run(Object object) {

    }
}

/**
 *
 *
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 *
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *
 * 计算从根到叶子节点生成的所有数字之和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *   1
 *  / \
 * 2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 * 示例 2:
 *
 * 输入: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * 输出: 1026
 * 解释:
 * 从根到叶子节点路径 4->9->5 代表数字 495.
 * 从根到叶子节点路径 4->9->1 代表数字 491.
 * 从根到叶子节点路径 4->0 代表数字 40.
 * 因此，数字总和 = 495 + 491 + 40 = 1026.
 *
 *
 */