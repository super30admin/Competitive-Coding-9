// Time complexity: O(N)
// Space complexity: O(N)
// where N - max no of days

import java.util.*;

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        
        int maxDate = days[days.length - 1];
        int[] dp = new int[maxDate + 1];
        HashSet<Integer> set = new HashSet<>();
        
        for(int n: days)
        {
            set.add(n);
        }
        
        dp[0] = 0;
        
        for(int i = 1; i < dp.length; i++)
        {
            if(set.contains(i))
                dp[i] = Math.min(dp[i-1]+costs[0], Math.min(dp[Math.max(0, i-7)]+costs[1], dp[Math.max(0, i-30)]+costs[2]));
            else
                dp[i] = dp[i-1];
        }
        
        return dp[dp.length - 1];
        
    }
}