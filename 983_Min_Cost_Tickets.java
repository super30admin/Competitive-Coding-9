    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/minimum-cost-for-tickets/
    Time Complexity for operators : o(n) .. n is the length of the days array
    Extra Space Complexity for operators : o(m) .. max no of days
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. 
                    A) Create an DP array of dp[days[n-1]+1].
                    B) Add all values of days into hashset. So, that we can do calculation of input days.
                    C) Now traverse thru dp array one by one.
                    D) if i is part of hashset that means its part of input, in that case check if it is >=30 than do
                            Math.min(dp[i - 1] + costs[0], Math.min((dp[i - 7]) + costs[1], dp[i - 30] + costs[2]));
                        if it is >=7 then,
                            Math.min(dp[i - 1] + costs[0], Math.min((dp[i - 7]) + costs[1], costs[2]));
                        if not then,
                            Math.min(dp[i - 1] + costs[0], Math.min(costs[1], costs[2]));
                    E) If it is not part of hashset then dp[i] = dp[i - 1];
                    F) At the end, return last element from dp array.
				
    */ 
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        // base case
        if(days.length == 0 || costs.length == 0)
            return 0;
        
        int n = days.length;
        int m = costs.length;
        
        int dp [] = new int[days[n-1]+1];
        HashSet<Integer> hs = new HashSet<>();
        
        for(int i=0;i<days.length;i++){
            hs.add(days[i]);
        }
        
        for(int i=1; i<dp.length; i++){
            
            if (hs.contains(i)) {
				if (i >= 30) {
					dp[i] = Math.min(dp[i - 1] + costs[0], Math.min((dp[i - 7]) + costs[1], dp[i - 30] + costs[2]));
				} else if (i >= 7) {
					dp[i] = Math.min(dp[i - 1] + costs[0], Math.min((dp[i - 7]) + costs[1], costs[2]));
				} else {
					dp[i] = Math.min(dp[i - 1] + costs[0], Math.min(costs[1], costs[2]));
				}
			} else {
				dp[i] = dp[i - 1];
			}
        }

        return dp[dp.length-1];
    }
}