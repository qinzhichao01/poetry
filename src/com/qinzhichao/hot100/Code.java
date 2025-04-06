package com.qinzhichao.hot100;

import java.io.FileOutputStream;
import java.util.*;
import java.util.stream.Collectors;

public class Code {

    //  颜色分类
    public void sortColors(int[] nums) {

        int left = 0;
        int right = 0;

        while (left < nums.length && right < nums.length) {
            while (left < nums.length && nums[left] == 0) {
                left++;

            }
            while (right < nums.length && nums[right] != 0) {
                right++;
            }
            if (right < nums.length && left < nums.length) {
                nums[right] = nums[left];
                nums[left] = 0;
            }
        }
        right = left;
        while (left < nums.length && right < nums.length) {
            while (left < nums.length && nums[left] == 1) {
                left++;

            }
            while (right < nums.length && nums[right] != 1) {
                right++;
            }
            if (right < nums.length && left < nums.length) {
                nums[right] = nums[left];
                nums[left] = 1;
            }
        }

    }


    //只出现一次的数字

    public int singleNumber(int[] nums) {

        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;

    }

    //  只出现一次的数字
    public int majorityElement(int[] nums) {
        int res = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == res)
                count++;
            else
                count--;

            if (count == 0)
                res = nums[i + 1];

        }
        return res;

    }


    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int left = dp[i - 1][j] + 1;
                int down = dp[i][j - 1] + 1;
                int left_down = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    left_down++;
                }
                dp[i][j] = Math.min(left, Math.min(down, left_down));

            }
        }
        return dp[m][n];

    }


    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int maxLen = 1;
        int start = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();

        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (charArray[i] != charArray[j]) {
                    dp[j][i] = false;
                } else {
                    if (i - j < 3) {
                        dp[j][i] = true;
                    } else {
                        dp[j][i] = dp[j + 1][i - 1];
                    }
                }
                if (dp[j][i] && maxLen < i - j + 1) {
                    start = j;
                    maxLen = i - j + 1;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }


    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = 0;
        char[] charArray = s.toCharArray();
        int ans = 0;
        for (int i = 1; i < s.length(); i++) {
            if (charArray[i] == '(') {
                dp[i] = 0;
                continue;
            }
            if (charArray[i - 1] == '(') {
                dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
            } else if (i - dp[i - 1] > 0 && charArray[i - dp[i - 1] - 1] == '(') {
                dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
            }
            ans = Math.max(ans, dp[i]);

        }
        return ans;
    }


    public int longestValidParentheses2(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    ans = Math.max(ans, i - stack.peek());
                }
            }
        }
        return ans;
    }


    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    temp.add(1);
                } else {
                    temp.add(list.get(j - 1).get(j - 1) + list.get(j - 1).get(j));
                }
            }
        }
        return list;
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }


    public int largestRectangleArea(int[] heights) {

        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            int h = heights[i];
            int left = i;
            while (left > 0 && heights[left - 1] >= h) {
                left--;
            }
            int right = i;
            while (right < heights.length - 1 && heights[right + 1] >= h) {
                right++;
            }
            res = Math.max(res, (right - left + 1) * heights[i]);
        }
        return res;

    }


    public int findMin(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        if (nums[0] < nums[nums.length - 1])
            return nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                return nums[i + 1];
        }
        return 0;
    }


    class Solution {
        public int search(int[] nums, int target) {
            int n = nums.length;
            if (n == 0) {
                return -1;
            }
            if (n == 1) {
                return nums[0] == target ? 0 : -1;
            }
            int l = 0, r = n - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                // 判断是否在前一段数组上
                if (nums[0] <= nums[mid]) {
                    if (nums[0] <= target && target < nums[mid]) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                } else {
                    if (nums[mid] < target && target <= nums[n - 1]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
            }
            return -1;
        }
    }


    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> list = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            int t = temperatures[i];
            while (!list.isEmpty() && t > temperatures[list.peek()]) {
                Integer last = list.pop();
                ans[last] = i - last;
            }
            list.push(i);
        }
        return ans;
    }


    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            int len = str.length();
            for (int i = 0; i < len; i++) {
                count[str.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (count[i] != 0) {
                    sb.append(('a' + i));
                    sb.append(count[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }



    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            countMap.put(num, num);
        }
        int max = 0;
        for (int num : nums) {
            if (countMap.containsKey(num - 1)) {
                continue;
            }
            int temp = num;
            int count = 0;
            while (countMap.containsKey(temp)) {
                count++;
                temp++;
            }
            max = Math.max(max, count);
        }
        return max;
    }


    public static void main(String[] args) {
        Code code = new Code();
        code.groupAnagrams(new String[]{"", ""});
    }
}
