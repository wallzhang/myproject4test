package com.wall.myproject4test.leedcode.singlenumber;
//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
//
// 说明：
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
//
// 示例 1:
//
// 输入: [2,2,1]
//输出: 1
//
//
// 示例 2:
//
// 输入: [4,1,2,1,2]
//输出: 4
// Related Topics 位运算 哈希表
// 👍 1682 👎 0


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        // 解法1: 通过集合存储，出现第二次则删除，最后留下的就是单独的数据
//        Set<Integer> set = new HashSet();
//        for (int i = 0; i < nums.length; i++) {
//            if(set.contains(nums[i])){
//                set.remove(nums[i]);
//            }else {
//                set.add(nums[i]);
//            }
//        }
//        return set.iterator().next();
        // 解法2: 通过hashMap进行存储,出现第二次则+1,最后遍历hashMap获取次数为1的数据。
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if(map.containsKey(nums[i])){
//                map.put(nums[i],2);
//            }else {
//                map.put(nums[i],1);
//            }
//        }
//        AtomicInteger res = new AtomicInteger();
//        map.forEach((key,value)->{
//            if(value == 1){
//                res.set(key);
//            }
//        });
//        return res.get();
        // 解法3: 通过位运算来判断，
        // 位运算特点，任何数和0做位运算结果为任何数
        // 任何数和本身做位运算结果为0
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
