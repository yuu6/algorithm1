package com.yuu6.everyday;

public class DetectCycle {
    public static ListNode detectCycle(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode node1 = head.next;
        ListNode node2 = head.next.next;
        Boolean cycle = false;

        do {
            node1 = node1.next;
            if (node2.next == null){
                break;
            }else {
                node2 = node2.next.next;
            }
            if (node1 == node2){
                cycle = true;
                break;
            }
        }while(node1 != null && node2 != null);

        if (!cycle){
            return null;
        }
        ListNode node3 = head;
        while(node3 != node1){
            node1 = node1.next;
            node3 = node3.next;
        }
        return node1;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(0);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode2;

        ListNode res = DetectCycle.detectCycle(listNode1);
        System.out.println(res.val);
    }
}
