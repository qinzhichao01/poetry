package com.qinzhichao.leetcode_master;

import com.qinzhichao.common.ListNode;
import com.qinzhichao.common.TreeNode;

import java.util.*;

public class C_Extra {

    // https://leetcode.cn/problems/how-many-numbers-are-smaller-than-the-current-number/
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] clone = nums.clone();
        Arrays.sort(clone);
        int[] ans = new int[nums.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = clone.length - 1; i >= 0; i--) {
            map.put(clone[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            ans[i] = map.get(num);
        }
        return ans;
    }


    // 有效山脉数组
    public boolean validMountainArray(int[] arr) {
        if (arr == null || arr.length < 3) return false;
        int changeCount = 0;
        int pre_1 = arr[0];
        boolean up = true;
        if (arr[1] < pre_1) {
            return false;
        }

        for (int i = 1; i < arr.length; i++) {
            if ((pre_1 > arr[i] && up) || (pre_1 < arr[i] && !up)) {
                changeCount++;
            }
            if (arr[i] == pre_1) {
                return false;
            }
            up = arr[i] > pre_1;
            pre_1 = arr[i];
        }
        return changeCount == 1;

    }

    public void rotate(int[] nums, int k) {
        int[] ans = new int[nums.length];
        k = k % nums.length;
        for (int i = 0; i < nums.length; i++) {
            int index = (i + nums.length - k) % nums.length;
            ans[i] = nums[index];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = ans[i];
        }
    }

    public int pivotIndex(int[] nums) {
        int length = nums.length;
        int[] presum = new int[length];
        presum[0] = nums[0];
        for (int i = 1; i < length; i++) {
            presum[i] = nums[i] + presum[i - 1];
        }


        for (int i = 0; i < length; i++) {
            if (presum[i] - nums[i] == presum[length - 1] - presum[i]) {
                return i;
            }
        }
        return -1;
    }


    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head;
        ListNode next = head.next;
        head.next = null;

        ListNode listNode = swapPairs(next.next);
        next.next = head;
        head.next = listNode;
        return next;
    }

    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }


    public int sumNumbers(TreeNode root, int sum) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return sum + root.val;
        }

        return sumNumbers(root.left, sum * 10 + root.val) + sumNumbers(root.right, sum * 10 + root.val);

    }


    public String predictPartyVictory(String senate) {
        char[] charArray = senate.toCharArray();


        while (true) {
            for (int k = 0; k < charArray.length; k++) {
                int i = k + 1;
                if (charArray[k] == 'R') {
                    while (i < charArray.length * 2) {
                        int j = i % charArray.length;
                        if (charArray[j] == 'D') {
                            charArray[j] = '0';
                            break;
                        } else {
                            i++;
                        }
                    }
                } else if (charArray[k] == 'D') {
                    while (i < charArray.length * 2) {
                        int j = i % charArray.length;
                        if (charArray[j] == 'R') {
                            charArray[j] = '0';
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            }
            int countR = 0;
            int countD = 0;
            for (char c : charArray) {
                if (c == 'R') {
                    countR++;
                }
                if (c == 'D') {
                    countD++;
                }
            }
            if (countR == 0) {
                return "Dire";
            }
            if (countD == 0) {
                return "Radiant";
            }
        }
    }

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] f = new int[n], g = new int[n];
        int max = 1;
        for (int i = 0; i < n; i++) {
            f[i] = g[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (f[i] < f[j] + 1) {
                        f[i] = f[j] + 1;
                        g[i] = g[j];
                    } else if (f[i] == f[j] + 1) {
                        g[i] += g[j];
                    }
                }
            }
            max = Math.max(max, f[i]);
        }
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (f[i] == max) {

                ans = ans + g[i];
            }
        }
        return ans;
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean[] isVisited = new boolean[rooms.size()];
        isVisited[0] = true;
        Deque<Integer> deque = new ArrayDeque<>();
        for (Integer i : rooms.get(0)) {
            deque.push(i);
        }
        while (!deque.isEmpty()) {
            int cur = deque.pollFirst();
            isVisited[cur] = true;
            List<Integer> list = rooms.get(cur);
            for (Integer i : list) {
                if (isVisited[i]) {
                    continue;
                }
                deque.push(i);
            }
        }

        for (boolean b : isVisited) {
            if (!b) {
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        C_Extra test = new C_Extra();
        System.out.println(test.findNumberOfLIS(new int[]{1, 3, 2}));
    }

}
