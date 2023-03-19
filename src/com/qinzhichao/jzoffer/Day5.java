package com.qinzhichao.jzoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qinzhichao02
 * create 2022/12/1 13:05
 */
public class Day5 {

    /**
     * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的某个变位词。
     * 换句话说，第一个字符串的排列之一是第二个字符串的子串 。
     */
    public boolean checkInclusion(String s1, String s2) {
        List<String> strings = fullArrangement(s1);
        for (String string : strings) {
            if (s2.contains(string)) {
                return true;
            }
        }
        return false;
    }

    private List<String> fullArrangement(String s) {
        List<String> list = new ArrayList<>();//生成一个List集合来存储全排列的结果
        list.add("" + s.charAt(0));//初始化list数组，初始元素为字符串的第一个元素
        for (int i = 1; i < s.length(); i++) {
            List<String> new_list = new ArrayList<>();//创建一个临时数组来存储下一步生成的结果
            char c = s.charAt(i);//获取此时应该插入的字符
            //对当前的数组进行遍历操作
            for (String str : list) {
                new_list.add(str + c);//新字符插入到字符串的后面
                new_list.add(c + str);//新字符插入到字符串前面
                //字符插入字符串中间的操作用循环完成
                for (int j = 1; j < str.length(); j++) {//新字符插入到字符串中间
                    String tem = str.substring(0, j) + c + str.substring(j);
                    new_list.add(tem);
                }
            }
            list = new_list;//将生成的新的newlist集合同步
        }
        return list;
    }

}
