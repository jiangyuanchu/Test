package jyc.leetcode;

import jyc.annotation.QuickStart;
import jyc.aop.LeetCodeBase;
import jyc.utils.LeetCodeQuickStart;
import jyc.utils.LeetCodeUtils;
import jyc.utils.TreeNode;

public class LeetCode687 implements LeetCodeBase {

    int ans;
    @QuickStart
    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        maxLength(root);
        return ans;
    }

    private int maxLength(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftNode = maxLength(root.left);
        int rightNode = maxLength(root.right);
        int left = 0;
        int right = 0;
        if(root.left != null && root.left.val == root.val){
            left += leftNode + 1;
        }
        if(root.right != null && root.right.val == root.val){
            right += rightNode + 1;
        }
        ans = Math.max(ans, left + right);
        return Math.max(left, right);

    }

    public static void main(String[] args) throws Exception{
        System.out.println(LeetCodeQuickStart.quickStart(LeetCode687.class, LeetCodeUtils.initTreeNode(new Integer[]{1, 4, 5, 4, 4, 5})));
    }

    @Override
    public void run(Object object) {

    }

}
