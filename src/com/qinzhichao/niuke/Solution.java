package com.qinzhichao.niuke;


/**
 * 数据流中的中位数
 * <a href="https://www.nowcoder.com/practice/9be0172896bd43948f8a32fb954e1be1?tpId=295&tqId=23457&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj">...</a>
 */

import java.util.*;

public class Solution {
    //小顶堆，元素数值都比大顶堆大
    private PriorityQueue<Integer> max = new PriorityQueue<>();
    //大顶堆，元素数值较小
    private PriorityQueue<Integer> min = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));

    //维护两个堆，取两个堆顶部即与中位数相关
    public void Insert(Integer num) {
        //先加入较小部分
        min.offer(num);
        //将较小部分的最大值取出，送入到较大部分
        max.offer(min.poll());
        //平衡两个堆的数量
        if (min.size() < max.size())
            min.offer(max.poll());
    }

    public Double GetMedian() {
        //奇数个
        if (min.size() > max.size())
            return (double) min.peek();
        else
            //偶数个
            return (double) (min.peek() + max.peek()) / 2;
    }
}

