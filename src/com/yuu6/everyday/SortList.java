package com.yuu6.everyday;

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head, q = head, pre = null;
        while (q != null && q.next != null) {
            pre = p;
            p = p.next;
            q = q.next.next;
        }
        pre.next = null;
        ListNode l = sortList(head);
        ListNode r = sortList(p);
        return merge(l, r);
    }

    private ListNode merge(ListNode l, ListNode r) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l != null && r != null) {
            if (l.val <= r.val) {
                cur.next = l;
                cur = cur.next;
                l = l.next;
            } else {
                cur.next = r;
                cur = cur.next;
                r = r.next;
            }
        }
        if (l != null) {
            cur.next = l;
        }
        if (r != null) {
            cur.next = r;
        }
        return dummyHead.next;
    }


    public static void main(String[] args) {
        SortList sortList = new SortList();
        ListNode l = new ListNode(1);
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(9);
        ListNode l6 = new ListNode(6);
        l.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;


        ListNode res = sortList.sortList(l);
        System.out.println(res);
        ListNode cur = res;
        while (cur != null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
