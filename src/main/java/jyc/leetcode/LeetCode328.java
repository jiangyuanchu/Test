package jyc.leetcode;

import jyc.annotation.QuickStart;
import jyc.aop.LeetCodeBase;
import jyc.utils.LeetCodeQuickStart;
import jyc.utils.LeetCodeUtils;
import jyc.utils.ListNode;

public class LeetCode328 implements LeetCodeBase {

    @QuickStart
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even = head.next;
        ListNode start = even.next;
        int count = 0;
        while(start != null){
            if(count % 2 == 0){
                odd.next = start;
                odd = odd.next;
            }else{
                even.next = start;
                even = even.next;
            }
            count++;
            start = start.next;
        }
        even.next = null;
        odd.next = evenHead;
        return head;

    }

    public static void main(String[] args) throws Exception {
        LeetCodeUtils.printListNode((ListNode)LeetCodeQuickStart.quickStart(LeetCode328.class, LeetCodeUtils.initOneWayListNodeInit(new Integer[]{2,1,3,5,6,4,7})));
    }

    @Override
    public void run(Object object) {

    }

}
