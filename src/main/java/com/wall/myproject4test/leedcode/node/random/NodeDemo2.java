package com.wall.myproject4test.leedcode.node.random;

/**
* @Description: leedcode 92题 单向链表反转2
* @Author: zhang.zw
* @Date: 2021/1/4 
*/
public class NodeDemo2 {

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
        NextNode head3 = reverseNode2(node1,2,4);
        while (head3 != null){
            System.out.print(head3.val);
            head3 = head3.next;
            if(head3 != null){
                System.out.print("->");
            }
        }
        System.out.println("\n");
    }

    public static NextNode reverseNode2(NextNode head, int m, int n){
        // 判断是否是空节点
        if(head == null || m >= n){
            return head;
        }
        // 预处理新增一个哨兵节点
        NextNode dump = new NextNode(-1);
        dump.next = head;
        head = dump;
        // 遍历至m节点的前prev节点
        for (int i = 1; i < m; i++){
            head = head.next;
        }
        // m,m的prev节点,n节点,n的post节点
        NextNode prevM = head;
        NextNode nodeM = head.next;
        NextNode nodeN = nodeM;
        NextNode postN = nodeN.next;
        // reverse和反转链表1类似
        for (int i = m; i < n; i++) {
            NextNode next = postN.next;
            postN.next = nodeN;

            nodeN = postN;
            postN = next;
        }
        // 反转结束后,原m的prev节点指向从m改为n，nodeM的指向指向n后面的postN节点
        nodeM.next = postN;
        prevM.next = nodeN;

        return dump.next;
    }
}
