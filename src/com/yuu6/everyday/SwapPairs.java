package com.yuu6.everyday;

/**
 * @Author: yuu6
 * @Date: 2022/05/25/下午10:46
 */
public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode one = head;
        ListNode tempOne = one;
        ListNode two = head.next;
        ListNode tempTwo = two;

        while(tempOne != null && tempTwo != null){
            tempOne.next = tempTwo.next;
            tempOne = tempOne.next;
            if (tempOne != null) {
                tempTwo.next = tempOne.next;
                tempTwo = tempTwo.next;
            }
        }

        ListNode res = two;
        ListNode nextOne = one.next;
        ListNode nextTwo = two.next;
        ListNode preOne = null;
        while(one != null){
            two.next = one;
            nextOne = one.next;
            one.next = nextTwo;
            preOne = one;
            two = nextTwo;
            if (two == null){
                break;
            }
            nextTwo = two.next;
            one = nextOne;
        }

        if (one != null){
            preOne.next = nextOne;
        }

        return res;
    }

    public static void main(String[] args) {
        SwapPairs swapPairs = new SwapPairs();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
//        ListNode listNode4 = new ListNode(4);
        listNode1.next  =listNode2;
        listNode2.next  =listNode3;
//        listNode3.next  =listNode4;
        ListNode res = swapPairs.swapPairs(listNode1);
        ListNode temp = res;
        while(temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
