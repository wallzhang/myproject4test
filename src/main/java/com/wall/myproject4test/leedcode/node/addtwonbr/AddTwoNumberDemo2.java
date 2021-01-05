package com.wall.myproject4test.leedcode.node.addtwonbr;


import java.util.ArrayList;
import java.util.List;

/**
* @Description: 两数相加2 leedcode 445
 * 有点问题，int不能处理过大的数据，放参考demo3写法
* @Author: zhang.zw
* @Date: 2021/1/5 
*/
public class AddTwoNumberDemo2 {

    public static void main(String[] args) {
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
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        while (l1 != null){
            sb1.append(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            sb2.append(l2.val);
            l2 = l2.next;
        }
        int res = Integer.parseInt(sb1.toString())+ Integer.parseInt(sb2.toString());
        int number = 0;
        ListNode resNode = new ListNode(-1);
        ListNode pre = resNode;
        List<Integer>  list = new ArrayList<>();
        while (res >=1){
            number = res%10;
            list.add(number);
            res = res/10;
        }
        for (int i = list.size()-1; i >=0 ; i--) {
            ListNode next =  new ListNode(list.get(i));
            resNode.next = next;
            resNode = resNode.next;
        }
        return pre.next;
    }
}
