package jyc.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * LeetCode标准二叉树
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val) { this.val = val; }
}


/**
 * 二叉树模型
 *
 *          A
 *         / \
 *        B   C
 *
 *
 * 前序遍历 ： A、B、C  （中、左、右）
 * 中序遍历 :  B、A、C  （左、中、右）
 * 后序遍历 ： B、C、A  （左、右、中）
 *
 */