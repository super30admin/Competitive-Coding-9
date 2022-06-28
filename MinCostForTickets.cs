using System;
using System.Collections.Generic;

namespace Algorithms
{
    /// Time Complexity : O(W) W = 365
    // Space Complexity :O(W) 
    // Did this code successfully run on Leetcode :Yes
    // Any problem you faced while coding this :  No 
    public class MinCostForTickets
    {
        int[] costs;
        int[] memo;
        HashSet<int> set;
        public int MincostTickets(int[] days, int[] costs)
        {
            this.costs = costs;
            memo = new int[366];
            set = new HashSet<int>();
            for (int i = 0; i < days.Length; i++)
            {
                set.Add(days[i]);
            }

            return dp(1);
        }

        public int dp(int i)
        {
            if (i > 365) return 0;
            if (memo[i] != 0)
            {
                return memo[i];
            }
            int ans;
            if (set.Contains(i))
            {
                ans = Math.Min((dp(i + 1) + costs[0]), (dp(i + 7) + costs[1]));
                ans = Math.Min(ans, (dp(i + 30) + costs[2]));
            }
            else
            {
                ans = dp(i + 1);
            }
            memo[i] = ans;
            return ans;
        }

    }
}
