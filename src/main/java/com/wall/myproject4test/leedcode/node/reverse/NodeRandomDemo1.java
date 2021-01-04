package com.wall.myproject4test.leedcode.node.reverse;


import java.util.HashMap;
import java.util.Map;

/**
* @Description: leedcode 138题，深度零拷贝
* @Author: zhang.zw
* @Date: 2021/1/4
*/
public class NodeRandomDemo1 {

    public static void main(String[] args) {

    }

    public NodeRandom copyRandomPoint1(NodeRandom head){
        if(head ==null){
            return head;
        }
        // 新建map存储数据
        Map<NodeRandom,NodeRandom> map = new HashMap<>();
        // 创建假节点
        NodeRandom dummy = new NodeRandom(-1);
        dummy.next = head;
        head = dummy;
        return head;
    }
}
