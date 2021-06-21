package jyc.leetcode;

import jyc.annotation.QuickStart;
import jyc.aop.LeetCodeBase;
import jyc.utils.LeetCodeQuickStart;
import jyc.utils.LeetCodeUtils;
import jyc.utils.ListNode;

public class LeetCode82 implements LeetCodeBase {

    @QuickStart
    public ListNode deleteDuplicates(ListNode head) {
        ListNode top = head, start = head, end = head;
        while(end.next != null){
            if(end.next.val != start.val && end.val != start.val){
                end = end.next;
                start = end;
            }else if(end.next.val == start.val){
                end = end.next;
            }else{
                if(top == start){
                    top = end.next;
                    end = end.next;
                    start = end;
                    head = top;
                }else{
                    while(top.next != start){
                        top = top.next;
                    }
                    top.next = end.next;
                    end = end.next;
                    start = end;
                }
            }
        }
        return head;
    }

    public static void main(String[] args) throws Exception {
        ListNode node = LeetCodeUtils.initOneWayListNodeInit(new Integer[]{1, 2, 3, 3, 4, 4, 5});
        LeetCodeUtils.printListNode((ListNode) LeetCodeQuickStart.quickStart(LeetCode82.class, node));
    }


    @Override
    public void run(Object object) {

    }

}
