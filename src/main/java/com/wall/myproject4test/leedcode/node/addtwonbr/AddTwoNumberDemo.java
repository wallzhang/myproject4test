package com.wall.myproject4test.leedcode.node.addtwonbr;


/** 
* @Description: leedcode 2,sumTwo
* @Author: zhang.zw
* @Date: 2021/1/4 
*/
public class AddTwoNumberDemo {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);
        l1.next = l12;
        l12.next = l13;
        ListNode l2 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);
        l2.next = l22;
        l22.next = l23;

        ListNode res = addTwoNumbers(l1,l2);
        while (res != null){
            System.out.print(res.val);
            res = res.next;
        }

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 判断
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        // 标准情况两链表长度相等
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        int countVal = 0;
        int finalVal = 0;
        int flag = 0;
        while (l1 != null && l2 != null){
            countVal = l1.val + l2.val + flag;
            finalVal = countVal%10;
            flag = countVal/10;
            ListNode next = new ListNode(finalVal);
            dummy.next = next;
            dummy = dummy.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        // l1大于l2的情况下
        if(l1 != null){
            countVal = l1.val + flag;
            finalVal = countVal%10;
            flag = countVal/10;
            ListNode next = new ListNode(finalVal);
            dummy.next = next;
            dummy = dummy.next;
            l1 = l1.next;
        }
        if(l2 != null){
            countVal = l2.val + flag;
            finalVal = countVal%10;
            flag = countVal/10;
            ListNode next = new ListNode(finalVal);
            dummy.next = next;
            dummy = dummy.next;
            l2 = l2.next;
        }
        if(flag!=0){
            ListNode next = new ListNode(flag);
            dummy.next = next;
        }
        return res.next;
    }
}
