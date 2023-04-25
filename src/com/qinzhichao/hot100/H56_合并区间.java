package com.qinzhichao.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author qinzhichao
 * created at 2023/4/25 23:04
 **/
public class H56_合并区间 {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> result = new ArrayList<>();
        int[] temp = intervals[0];
        int[] temp2;

        for (int i = 1; i < intervals.length; i++) {
            temp2 = intervals[i];
            if (temp2[0] <= temp[1]) {
                if (temp2[1] >= temp[1]) {
                    temp[1] = temp2[1];
                }
            } else {
                result.add(temp);
                temp = temp2;
            }
        }
        result.add(temp);
        int res[][] = new int[result.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i][0] = result.get(i)[0];
            res[i][1] = result.get(i)[1];
        }
        return res;
    }

}
