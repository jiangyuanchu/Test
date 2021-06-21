package jyc.leetcode;

import jyc.aop.LeetCodeBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字典树/前缀树
 */
public class LeetCode208 implements LeetCodeBase {

    class Trie {

        private Map<Character, TreeNode> trieBarrel;

        /** Initialize your data structure here. */
        public Trie() {
            trieBarrel = new HashMap<>();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            //判断为空不允许添加
            if(word == null || word.length() == 0){
                System.out.println("the word is empty.");
                return;
            }
            //当前指针指向节点
            TreeNode nowNode = null;
            //HashMap key
            char c = word.charAt(0);
            if (trieBarrel.containsKey(c)) {
                //得到首节点
                nowNode = trieBarrel.get(c);
                //首节点与Key相同 从字符串第二位开始遍历 长度不足时跳过；
                for(int i = 1; i < word.length(); i++){
                    boolean isExist = false;
                    //遍历当前节点的子节点
                    for(TreeNode treeNode : nowNode.nextNodes){
                        if(treeNode.value == word.charAt(i)){
                            nowNode = treeNode;
                            isExist = true;
                            break;
                        }
                    }
                    if(isExist){
                        continue;
                    }
                    TreeNode newTreeNode = new TreeNode(word.charAt(i));
                    nowNode.nextNodes.add(newTreeNode);
                    nowNode = newTreeNode;
                }
                //设置当前指针指向节点为终结节点
                nowNode.isEnd = true;
            } else {
                TreeNode headNode, next, newTreeNode = new TreeNode();
                headNode = newTreeNode;
                for(char ch : word.toCharArray()){
                    next = new TreeNode(ch);
                    newTreeNode.nextNodes.add(next);
                    newTreeNode = next;
                }
                newTreeNode.isEnd = true;
                trieBarrel.put(c, headNode.nextNodes.get(0));
            }

        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            char c = word.charAt(0);
            if(!trieBarrel.containsKey(c)){
                return false;
            }
            TreeNode nowNode = trieBarrel.get(c);
            for(int i = 1; i < word.length(); i++){
                boolean isExist = false;
                //遍历当前节点的子节点
                for(TreeNode treeNode : nowNode.nextNodes){
                    if(treeNode.value == word.charAt(i)){
                        nowNode = treeNode;
                        isExist = true;
                        break;
                    }
                }
                if(isExist){
                    continue;
                }
                return false;
            }
            return nowNode.isEnd;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            char c = prefix.charAt(0);
            if(!trieBarrel.containsKey(c)){
                return false;
            }
            TreeNode nowNode = trieBarrel.get(c);
            for(int i = 1; i < prefix.length(); i++){
                boolean isExist = false;
                //遍历当前节点的子节点
                for(TreeNode treeNode : nowNode.nextNodes){
                    if(treeNode.value == prefix.charAt(i)){
                        nowNode = treeNode;
                        isExist = true;
                        break;
                    }
                }
                if(isExist){
                    continue;
                }
                return false;
            }
            return true;
        }

        class TreeNode{
            public char value;
            public boolean isEnd = false;
            public List<TreeNode> nextNodes = new ArrayList<>();

            TreeNode(char value){
                this.value = value;
            }
            TreeNode(){}
        }
    }




    public static void main(String[] args) throws Exception {
        LeetCode208 leetCode208 = new LeetCode208();
        Trie trie = leetCode208.new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));

    }


    @Override
    public void run(Object object) {

    }

}
