package jyc.leetcode;

import jyc.annotation.QuickStart;
import jyc.aop.LeetCodeBase;
import jyc.utils.LeetCodeQuickStart;
import jyc.utils.LeetCodeUtils;
import jyc.utils.ListNode;
import jyc.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LeetCode147 implements LeetCodeBase {

    @QuickStart
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode top = head;
        ListNode last = head;
        ListNode index = top;
        while(last.next != null){
            ListNode inter = last.next;
            ListNode indexFront = index;
            boolean pd = true;
            do{
                if(inter.val < top.val){
                    top.next = inter.next;
                    inter.next = top;
                    top = inter;
                    pd = false;
                    break;
                }
                if(inter.val < index.val){
                    index.next = inter.next;
                    inter.next = index;
                    indexFront.next = inter;
                    pd = false;
                    break;
                }

                index = index.next;
                if(indexFront != index || indexFront.next != index){
                    indexFront = indexFront.next;
                }
            }while(top != last);
            if (pd) {
                last = last.next;
            }
        }


        return top;
    }

    public static void main(String[] args) throws Exception {
        LeetCodeUtils.printListNode((ListNode) LeetCodeQuickStart.quickStart(LeetCode147.class, LeetCodeUtils.initOneWayListNodeInit(new Integer[]{4,2,1,3})));
    }



    @Override
    public void run(Object object) {

    }

}
