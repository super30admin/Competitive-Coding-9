package competitiveCoding9;

import java.util.HashSet;
import java.util.Set;

public class MinimumCostForTickets {
	//Time Complexity : O(n), where n is max 365
	//Space Complexity : O(n)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public int mincostTickets(int[] days, int[] costs) {
        Set<Integer> set = new HashSet<>();
        for(int day: days)
            set.add(day);
        
        int[] dp = new int[days[days.length - 1] + 1];
        
        for(int i=1; i<dp.length; i++) {
            if(set.contains(i)) {
                int oneIdx = i - 1;
                int sevenIdx = Math.max(i - 7, 0);
                int thirtyIdx = Math.max(i - 30, 0);
                dp[i] = Math.min(dp[oneIdx] + costs[0], Math.min(dp[sevenIdx] + costs[1], dp[thirtyIdx] + costs[2]));
            } else {
                dp[i] = dp[i-1];
            }
        }
        
        return dp[days[days.length - 1]];
    }
}
