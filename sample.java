// Time Complexity : O(N), where N is the number of days in the year (max 365)
// Space Complexity : O(N), for the dp array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

import java.util.*;

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        Set<Integer> travelDays = new HashSet<>();
        for (int day : days)
            travelDays.add(day);
        int lastDay = days[days.length - 1];
        int[] dp = new int[lastDay + 1];
        for (int i = 1; i <= lastDay; i++) {
            if (!travelDays.contains(i)) {
                dp[i] = dp[i - 1];
            } else {
                int cost1 = dp[i - 1] + costs[0];
                int cost7 = dp[Math.max(0, i - 7)] + costs[1];
                int cost30 = dp[Math.max(0, i - 30)] + costs[2];
                dp[i] = Math.min(cost1, Math.min(cost7, cost30));
            }
        }
        return dp[lastDay];
    }
}
//
// Time Complexity : O(N * L^2), where N is the number of words and L is the
// length of each word
// Space Complexity : O(N * L), for the queue and visited set
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;

class Solution127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord))
            return 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord))
                    return level;
                char[] chars = word.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char old = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == old)
                            continue;
                        chars[j] = c;
                        String next = new String(chars);
                        if (wordSet.contains(next) && !visited.contains(next)) {
                            queue.offer(next);
                            visited.add(next);
                        }
                    }
                    chars[j] = old;
                }
            }
            level++;
        }
        return 0;
    }
}