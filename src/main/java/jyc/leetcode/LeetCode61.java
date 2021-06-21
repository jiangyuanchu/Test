package jyc.leetcode;

import jyc.annotation.QuickStart;
import jyc.aop.LeetCodeBase;
import jyc.utils.LeetCodeQuickStart;
import jyc.utils.LeetCodeUtils;
import jyc.utils.ListNode;

import java.util.Arrays;

public class LeetCode61 implements LeetCodeBase {

    @QuickStart
    public ListNode rotateRight(ListNode head, int k) {
        int size = 1, count = 1;
        ListNode root = head;
        ListNode fastPoint = head;
        ListNode slowHead = head;
        while(fastPoint.next != null){
            fastPoint = fastPoint.next;
            size++;
            count++;
            if(size > k + 1){
                size--;
                slowHead = slowHead.next;
            }
        }
        if(slowHead == head && k != count - 1){
            if(k % count == 0){
                return head;
            }else{
                return rotateRight(head, k % count);
            }
        }
        fastPoint.next = head;
        root = slowHead.next;
        slowHead.next = null;
        return root;
    }

    public static void main(String[] args) throws Exception {
        LeetCodeUtils.printListNode((ListNode) LeetCodeQuickStart.quickStart(LeetCode61.class, LeetCodeUtils.initOneWayListNodeInit(new Integer[]{1,2}), 1));
    }


    @Override
    public void run(Object object) {

    }

}
