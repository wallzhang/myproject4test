package com.wall.myproject4test.leedcode.node.addtwonbr;



/**
* @Description: 两数相加2 leedcode 445
* @Author: zhang.zw
* @Date: 2021/1/5 
*/
public class AddTwoNumberDemo3 {

    public static void main(String[] args) {
        // 6223+564 = 6787
        ListNode l1 = new ListNode(6);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(2);
        ListNode l14 = new ListNode(3);
        l1.next = l12;
        l12.next = l13;
        l13.next = l14;
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
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        l1 = reverseNode(l1);
        l2 = reverseNode(l2);
        ListNode res = AddTwoNumberDemo.addTwoNumbers(l1,l2);
        return reverseNode(res);
    }

    public static ListNode reverseNode(ListNode head){
        // 判断是否是空节点
        if(head == null){
            return head;
        }
        // 预处理第一个节点数据
        // 获取当前节点，和next节点，当前节点next的节点重置为null
        ListNode prev = head;
        ListNode current = head.next;

        prev.next = null;

        while (current !=null){
            // 获取当前节点current,下节点next,上节点prev
            ListNode next = current.next;
            // next节点重新赋值为prev
            current.next = prev;
            // 重赋值
            prev = current;
            current = next;
        }

        return prev;
    }
}
