package jyc.leetcode;

import jyc.aop.LeetCodeBase;
import jyc.utils.LeetCodeUtils;
import jyc.utils.ListNode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode143 implements LeetCodeBase {

    public void reorderList(ListNode head) {
        int nodeCount = 0;
        Queue<ListNode> leftQueue = new LinkedList<>();
        Queue<ListNode> rightQueue = new LinkedList<>();
        for(int i = 0; ; i++){
            if(head == null){
                break;
            }
            if(i % 2 == 0){
                leftQueue.add(head);
            }else {
                rightQueue.add(head);
            }
            head = head.next;
            nodeCount++;
        }
        ListNode headNode = new ListNode();
        ListNode mainNode = headNode;
        if(nodeCount % 2 == 0){
            for(int i = 0; ; i++){
                if(leftQueue.isEmpty()){
                    headNode.next = null;
                    break;
                }
                if(i % 2 == 0){
                    headNode.next = ((LinkedList<ListNode>) leftQueue).removeFirst();
                    headNode = headNode.next;
                    headNode.next = ((LinkedList<ListNode>) rightQueue).removeLast();
                    headNode = headNode.next;
                }else{
                    headNode.next = ((LinkedList<ListNode>) rightQueue).removeFirst();
                    headNode = headNode.next;
                    headNode.next = ((LinkedList<ListNode>) leftQueue).removeLast();
                    headNode = headNode.next;
                }
            }
        }else{
            for(int i = 0; ; i++){
                if(rightQueue.isEmpty() || leftQueue.isEmpty()){
                    headNode.next = null;
                    break;
                }
                if(i % 2 == 0){
                    headNode.next = ((LinkedList<ListNode>) leftQueue).removeFirst();
                    headNode = headNode.next;
                    if(!leftQueue.isEmpty()){
                        headNode.next = ((LinkedList<ListNode>) leftQueue).removeLast();
                        headNode = headNode.next;
                    }
                }else{
                    headNode.next = ((LinkedList<ListNode>) rightQueue).removeFirst();
                    headNode = headNode.next;
                    if(!leftQueue.isEmpty()){
                        headNode.next = ((LinkedList<ListNode>) rightQueue).removeLast();
                        headNode = headNode.next;
                    }
                }
            }
        }
        head = mainNode.next;
    }

    public static void main(String[] args) {
        LeetCode143 leetCode143 = new LeetCode143();
        ListNode root = LeetCodeUtils.initOneWayListNodeInit(new Integer[]{1,2,3,4});
        leetCode143.reorderList(root);
        LeetCodeUtils.printListNode(root);

    }



    @Override
    public void run(Object object) {

    }

}
