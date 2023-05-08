package com.qinzhichao.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个字符串 croakOfFrogs，它表示不同青蛙发出的蛙鸣声（字符串 "croak" ）的组合。由于同一时间可以有多只青蛙呱呱作响，所以 croakOfFrogs 中会混合多个 “croak” 。
 * <p>
 * 请你返回模拟字符串中所有蛙鸣所需不同青蛙的最少数目。
 * <p>
 * 要想发出蛙鸣 "croak"，青蛙必须 依序 输出 ‘c’, ’r’, ’o’, ’a’, ’k’ 这 5 个字母。如果没有输出全部五个字母，那么它就不会发出声音。如果字符串 croakOfFrogs 不是由若干有效的 "croak" 字符混合而成，请返回 -1 。
 *
 * @author qinzhichao02
 * create 2023/5/7 15:55
 */
public class L1419_数青蛙 {

    char[] charArray = {'c', 'r', 'o', 'a', 'k'};
    public Map<Character, Integer> map = new HashMap<>();

    public int minNumberOfFrogs(String croakOfFrogs) {
        for (int i = 0; i < charArray.length; i++) {
            map.put(charArray[i], i);
        }

        List<Croak> list = new ArrayList<>();
        char[] charArray = croakOfFrogs.toCharArray();

        for (char c : charArray) {
            boolean flag = false;
            for (Croak croak : list) {
                if (croak.put(c)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                Croak croak = new Croak();
                boolean bool = croak.put(c);
                if (!bool) {
                    return -1;
                }
                list.add(croak);
            }
        }
        for (Croak croak : list) {
            if (croak.nextIndex != 0) {
                return -1;
            }
        }
        return list.size();
    }

    class Croak {
        int nextIndex = 0;

        public Croak() {

        }

        public boolean put(char ch) {
            if (map.get(ch) == nextIndex) {
                nextIndex++;
                if (nextIndex == 5) {
                    nextIndex = 0;
                }
                return true;
            }
            return false;
        }
    }

}
