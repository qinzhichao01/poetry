package com.qinzhichao.hot100;

import com.qinzhichao.code.L567_字符串的排列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author qinzhichao02
 * create 2023/4/27 09:25
 */
public class H_24点游戏 {

    public boolean judgePoint24(int[] cards) {
        List<Double> doubleList = new ArrayList<>();
        for (int card : cards) {
            doubleList.add(card + 0.0);
        }
        return dfs(doubleList);
    }

    private boolean dfs(List<Double> doubleList) {
        if (doubleList.size() == 2) {
            List<Double> calList = cal(doubleList.get(0), doubleList.get(1));
            for (Double aDouble : calList) {
                if (Math.abs(aDouble - 24.0) < 0.001) {
                    return true;
                }
            }
            return false;
        }
        boolean bool = false;
        for (int i = 0; i < doubleList.size(); i++) {
            for (int j = i + 1; j < doubleList.size(); j++) {
                List<Double> res = cal(doubleList.get(i), doubleList.get(j));
                for (Double re : res) {
                    List<Double> list = new ArrayList<>();
                    list.add(re);
                    for (int k = 0; k < doubleList.size(); k++) {
                        if (k != i && k != j) {
                            list.add(doubleList.get(k));
                        }
                    }
                    bool = dfs(list);
                    if (bool) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public List<Double> cal(double a, double b) {
        List<Double> list = new ArrayList<>();
        list.add(a + b);
        list.add(a - b);
        list.add(a * b);
        list.add(a / b);
        list.add(b - a);
        list.add(b / a);
        return list;
    }
}
