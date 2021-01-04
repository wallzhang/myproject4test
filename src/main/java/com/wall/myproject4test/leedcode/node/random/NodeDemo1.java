package com.wall.myproject4test.leedcode.node.random;

/**
* @Description: leedcode 206题单向链表反转
* @Author: zhang.zw
* @Date: 2021/1/4 
*/
public class NodeDemo1 {

    public static void main(String[] args) {
        NextNode node1 = new NextNode(1);
        NextNode node2 = new NextNode(2);
        NextNode node3 = new NextNode(3);
        NextNode node4 = new NextNode(4);
        NextNode node5 = new NextNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        NextNode head2 = node1;
        while (head2 != null){
            System.out.print(head2.val);
            head2 = head2.next;
            if(head2 != null){
                System.out.print("->");
            }
        }
        System.out.println("\n");
        NextNode head3 = reverseNode(node1);
        while (head3 != null){
            System.out.print(head3.val);
            head3 = head3.next;
            if(head3 != null){
                System.out.print("->");
            }
        }
        System.out.println("\n");
    }

    public static NextNode reverseNode(NextNode head){
        // 判断是否是空节点
        if(head == null){
            return head;
        }
        // 预处理第一个节点数据
        // 获取当前节点，和next节点，当前节点next的节点重置为null
        NextNode prev = head;
        NextNode current = head.next;

        prev.next = null;

        while (current !=null){
            // 获取当前节点current,下节点next,上节点prev
            NextNode next = current.next;
            // next节点重新赋值为prev
            current.next = prev;
            // 重赋值
            prev = current;
            current = next;
        }

        return prev;
    }
}
