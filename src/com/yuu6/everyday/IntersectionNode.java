package com.yuu6.everyday;

public class IntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1 = 0, l2 = 0;
        ListNode node1 = headA;
        ListNode node2 = headB;

        while(node1 != null){
            l1 += 1;
            node1 = node1.next;
        }

        while(node2 != null){
            l2 += 1;
            node2 = node2.next;
        }

        node1 = headA;
        node2 = headB;

        if (l1 > l2){
            for (int i = 0; i < l1 - l2; i++) {
                node1 = node1.next;
            }
        }else{
            for (int i = 0; i < l2 - l1; i++) {
                node2 = node2.next;
            }
        }

        while(node1 != null){
            if (node1 == node2){
                return node1;
            }else{
                node1 = node1.next;
                node2 = node2.next;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        IntersectionNode intersectionNode = new IntersectionNode();

//        intersectionNode.getIntersectionNode()
    }
}
