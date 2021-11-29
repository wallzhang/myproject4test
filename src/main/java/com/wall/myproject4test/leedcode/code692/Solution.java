package com.wall.myproject4test.leedcode.code692;


import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

/**
* @Description:  前K个高频单词
* 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
* @Author: zhang.zw
* @Date: 2021/11/26 
*/
public class Solution {

    public static void main(String[] args) {
        List<String> list = topKFrequent(new String[]{"aaa", "bbb", "aaa", "ccc"}, 2);
        System.out.println(list);
    }
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if(map.containsKey(words[i])){
                map.put(words[i],map.get(words[i])+1);
            }else {
                map.put(words[i],1);
            }
        }
        List<Map.Entry<String, Integer>> collect = map.entrySet()
                .stream()
                .sorted(comparingByValue())
                .collect(Collectors.toList());
        List<String> result = new ArrayList<>();
        int length = collect.size();
        for (int i = 0; i < k; i++) {
            result.add(collect.get(length-1-i).getKey());
        }

        return result;
    }

    public static <K, V extends Comparable<? super V>> Comparator<Map.Entry<K,V>> comparingByValue() {
        return (Comparator<Map.Entry<K, V>> & Serializable)
                (c1, c2) -> c1.getValue().compareTo(c2.getValue());
    }
}
