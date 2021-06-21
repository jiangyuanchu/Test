package jyc.leetcode;

import jyc.annotation.QuickStart;
import jyc.aop.LeetCodeBase;
import jyc.utils.LeetCodeQuickStart;
import jyc.utils.LeetCodeUtils;
import jyc.utils.ListNode;

import java.util.Arrays;

public class LeetCode206 implements LeetCodeBase {

    /**
     * 反转链表
     * @param head
     * @return
     */
    @QuickStart
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = head;
        ListNode temp = head.next;
        ListNode next = temp.next;
        while(temp != null){
            temp.next = pre;
            if(pre.equals(head)){
                pre.next = null;
            }
            pre = temp;
            temp = next;
            if(next != null){
                next = next.next;
            }
        }
        return pre;
    }

    public static void main(String[] args) throws Exception {
        LeetCodeUtils.printListNode((ListNode) LeetCodeQuickStart.quickStart(LeetCode206.class, LeetCodeUtils.initOneWayListNodeInit(new Integer[]{1,3,5,7,9})));
    }


    @Override
    public void run(Object object) {

    }

}
