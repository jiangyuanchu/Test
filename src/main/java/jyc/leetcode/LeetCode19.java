package jyc.leetcode;

import jyc.annotation.QuickStart;
import jyc.aop.LeetCodeBase;
import jyc.utils.LeetCodeQuickStart;
import jyc.utils.LeetCodeUtils;
import jyc.utils.ListNode;

import java.util.Arrays;

public class LeetCode19 implements LeetCodeBase {

    @QuickStart
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head;
        ListNode slow = head;
        ListNode fast = head;
        int step = n;
        while(fast.next != null){
            fast = fast.next;
            if(--step <= 0){
                if(pre != slow){
                    pre = slow;
                }
                slow = slow.next;
            }
        }
        if(pre == slow){
            return head.next;
        }
        pre.next = slow.next;
        return head;
    }

    public static void main(String[] args) throws Exception {
        LeetCodeUtils.printListNode((ListNode) LeetCodeQuickStart.quickStart(LeetCode19.class, LeetCodeUtils.initOneWayListNodeInit(new Integer[]{1}),1));
    }


    @Override
    public void run(Object object) {

    }

}
