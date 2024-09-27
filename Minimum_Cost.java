// Time Complexity :O(largest day)
// Space Complexity :O(largest day)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        if(days == null || days.length == 0)return 0;
        int lastDay = days[days.length-1];
        int[] dp = new int[lastDay+1];
        int[] passes = {1,7,30};
            
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0; i < days.length; i++){
            set.add(days[i]);
        }
        
        dp[0] = 0;
        
        for(int j = 1; j < dp.length; j++){
            if(set.contains(j))
                dp[j] = Math.min(dp[j-1]+costs[0], 
                        Math.min(dp[Math.max(0, j-7)]+costs[1],
                        dp[Math.max(0, j-30)]+costs[2]));
            else
                dp[j] = dp[j-1];
        }
        
        return dp[dp.length-1];
    }
}