
// Time Complexity : o(n)
// Space Complexity : o(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        if(days == null || days.length == 0)
            return 0;
        int[] dp = new int[days[days.length - 1] + 1];
        Set<Integer> set = new HashSet<>();
        
        for(int j=0;j<days.length;j++)
            set.add(days[j]);
        for(int i=1;i<dp.length;i++)
        {
            if(set.contains(i))
            {
                dp[i]=Math.min(dp[i-1]+costs[0],
                Math.min(dp[Math.max(i-7,0)]+costs[1],dp[Math.max(i-30,0)]+costs[2]));
            }
            else
            {
                dp[i]=dp[i-1];
            }
        }
        return dp[dp.length-1];
    }
}